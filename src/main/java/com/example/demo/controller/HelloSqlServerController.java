package com.example.demo.controller;

import java.security.Principal;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Attendance;
import com.example.demo.entity.User;
import com.example.demo.service.AttendanceService;
import com.example.demo.service.UserService;


@Controller
public class HelloSqlServerController {
    @Autowired
    UserService userService;
    @Autowired
    AttendanceService attendanceService;

    
    @RequestMapping("/")
    public String hello(Model model, Principal principal) {
        // 勤怠データの取得
      	String name = principal.getName();
      	User nowUser = userService.selectByMail(name);

      	List<Attendance> attendanceDataList = attendanceService.findByNameAttendanceData(nowUser);
      	      	
      	model.addAttribute("username", nowUser);
      	model.addAttribute("attendanceDataList", attendanceDataList);
        
//      	for(Attendance d : attendanceDataList) {
//      		System.out.println(d);
//      		System.out.println(d.getId());
//      		System.out.println(d.getUserID());
//      		System.out.println(d.getUserID().getName());
//      	}
        return "/user/index";
    }
    
    
    @GetMapping("/login")
    public String login() {
    	return "login";
    }

//    @GetMapping("user/index")
//    public String get(Model model, Principal principal) {
//        // 勤怠データの取得
//      	List<Attendance> attendanceDataList = attendanceService.findAllAttendanceData();
//
//      	model.addAttribute("attendanceDataList", attendanceDataList);
//        
//      	for(Attendance d : attendanceDataList) {
//      		System.out.println(d);
//      		System.out.println(d.getId());
//      		System.out.println(d.getUserID());
//      		System.out.println(d.getUserID().getName());
//      	}
//      	      	
//        String name = principal.getName();
//        
//        System.out.println(name);
//        
//        return "/user/index";
//    }
//    
    
    
    @PostMapping("/")
    public String post(@RequestParam String date,String breaktime,Model model, Principal principal) {

      	String name = principal.getName();
      	User nowUser = userService.selectByMail(name);

      	String[] d = date.split(" ");
   	    Date sqlDate = Date.valueOf(d[0]);
       	Time sqlTime = Time.valueOf(d[1] + ":00");
       	Time breakTime = Time.valueOf(breaktime + ":00");
      	
    	if(attendanceService.findByAdayAndUserID(sqlDate,nowUser) == null) {
    		System.out.println("登録");
    		attendanceService.create(sqlDate,sqlTime,nowUser);
       	   }else if(attendanceService.findByLdayAndUserID(sqlDate,nowUser) != null){
       		   System.out.println("確定");
       	   }else if(attendanceService.findByAdayAndUserID(sqlDate,nowUser) != null){
       		   System.out.println("更新");
       		   Attendance attendance = attendanceService.findByAdayAndUserID(sqlDate,nowUser);
       		   attendanceService.add(sqlDate,sqlTime,breakTime,attendance);
       	   }; 
//      	System.out.println(Arrays.toString(d));
//      	System.out.println(nowUser);
         model.addAttribute("username", principal.getName());
         model.addAttribute("date",date);
                  
         return hello(model,principal);
    }
    
    @GetMapping("/attendance/edit")
    public String edit(@RequestParam("id") int id, Model model, Principal principal) {

      	Attendance attendance = attendanceService.findById(id);
      	model.addAttribute("username", principal.getName());
      	model.addAttribute("attendance", attendance);

      	return "/attendance/edit";
    
    }
    @PostMapping("/update")
    public String update(@RequestParam("id") int id,
    		@RequestParam("aday") Date aday,@RequestParam("atime") Time atime,
    		@RequestParam("lday") Date lday,@RequestParam("ltime") Time ltime,
    		@RequestParam("breaktime") Time breaktime,
    		Model model, Principal principal) {

      	String name = principal.getName();
      	User nowUser = userService.selectByMail(name);

      	Attendance attendance = attendanceService.findByAdayAndUserID(aday,nowUser);

		attendanceService.update(atime,ltime,breaktime,attendance);

		return hello(model,principal);
 
    }
    
    @GetMapping("/attendance/delete")
    public String delete(@RequestParam("id") int id, Model model, Principal principal) {
      // ユーザー情報の削除
      attendanceService.delete(id);
      return "redirect:/";
    }

    @GetMapping("/month")
    public String month(@RequestParam("month") String month, Model model, Principal principal) {
    	System.out.print(month);
      return "user/index";
    }
}

























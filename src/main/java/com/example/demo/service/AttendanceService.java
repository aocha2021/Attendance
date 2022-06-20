package com.example.demo.service;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Attendance;
import com.example.demo.entity.User;
import com.example.demo.repository.AttendanceRepository;
import com.example.demo.repository.UserRepository;



@Service
public class AttendanceService {
    @Autowired
    AttendanceRepository attendanceRepository;

    @Autowired
    UserRepository userRepository;

    public Attendance findById(int id) {
        return attendanceRepository.findById(id);
    }
    
    public List<Attendance> findAllAttendanceData() {
        return attendanceRepository.findAll();
    }

    public List<Attendance> findByNameAttendanceData(User userID) {
        return attendanceRepository.findByUserID(userID);
    }
    
    public Attendance findByAdayAndUserID(Date date,User user) {
        return attendanceRepository.findByAdayAndUserID(date,user);
    }

    public Attendance findByLdayAndUserID(Date date,User user) {
        return attendanceRepository.findByLdayAndUserID(date,user);
    }


   public void create(Date date,Time time,User user) {
	   attendanceRepository.save(CreateAttendance(date,time,user));
   }
   
   public void add(Date date,Time time,Time breaktime,Attendance attendance) {
	   attendanceRepository.save(AddAttendance(date,time,breaktime,attendance));
   }
   
   public void update(Time atime,Time ltime,Time breaktime,Attendance attendance) {
	   attendanceRepository.save(UpdateAttendance(atime,ltime,breaktime,attendance));
   }
   
   public void delete(int id) {
	    Attendance attendance = findById(id);
	    attendanceRepository.delete(attendance);
   }

   private Attendance CreateAttendance(Date date,Time time,User user) {
       Attendance attendance = new Attendance();
       
   	   attendance.setUserID(user);
   	   attendance.setAday(date);
   	   attendance.setAtime(time);  
   	   
   	   return attendance;
   }

   private Attendance AddAttendance(Date date,Time time,Time breaktime,Attendance attendance) {
   	   attendance.setLday(date);
   	   attendance.setLtime(time);  
   	   attendance.setBreaktime(breaktime);
   	   return attendance;
   	   
   }
   
   private Attendance UpdateAttendance(Time atime,Time ltime,Time breaktime,Attendance attendance) {
   	   attendance.setAtime(atime);  
	   attendance.setLtime(ltime);  
   	   attendance.setBreaktime(breaktime);
   	   return attendance;   	   
   }
   
   
//   /**
//    * ユーザー情報新規登録
//    * @param user ユーザー情報
//    */
//   public void create(UserRequest userRequest) {
//       userRepository.save(CreateUser(userRequest));
//   }
//   /**
//    * ユーザーTBLエンティティの生成
//    * @param userRequest ユーザー情報リクエストデータ
//    * @return ユーザーTBLエンティティ
//    */
//   private User CreateUser(UserRequest userRequest) {
//       Date now = new Date();
//       User user = new User();
//       user.setName(userRequest.getName());
//       user.setAddress(userRequest.getAddress());
//       user.setPhone(userRequest.getPhone());
//       user.setCreateDate(now);
//       user.setUpdateDate(now);
//       return user;
//   }
    
}


package com.example.demo.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Attendance;
import com.example.demo.entity.User;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Integer> {
	List<Attendance> findByUserID(User userID);
	Attendance findByAdayAndUserID(Date date,User user);
	Attendance findByLdayAndUserID(Date date,User user);
	Attendance findById(int id);
}

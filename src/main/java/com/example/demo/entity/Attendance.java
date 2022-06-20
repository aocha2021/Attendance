package com.example.demo.entity;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "\"attendance\"")

public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "userID", referencedColumnName = "id")
    private User userID;
    @Column(name = "aday")
    private Date aday;
    @Column(name = "atime")
    private Time atime;
    @Column(name = "lday")
    private Date lday;
    @Column(name = "ltime")
    private Time ltime;
    @Column(name = "breaktime")
    private Time breaktime;
    

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public User getUserID() {
		return userID;
	}
	public void setUserID(User userID) {
		this.userID = userID;
	}

	public Date getAday() {
		return aday;
	}
	
	public void setAday(Date aday) {
		this.aday = aday;
	}
	
	public Time getAtime() {
		return atime;
	}
	
	public void setAtime(Time atime) {
		this.atime = atime;
	}
	
	public Date getLday() {
		return lday;
	}
	
	public void setLday(Date lday) {
		this.lday = lday;
	}
	
	public Time getLtime() {
		return ltime;
	}
	
	public void setLtime(Time ltime) {
		this.ltime = ltime;
	}
	
	public Time getBreaktime() {
		return breaktime;
	}
	
	public void setBreaktime(Time breaktime) {
		this.breaktime = breaktime;
	}
	
	
}

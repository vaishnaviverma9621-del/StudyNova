package com.project.StudyNova.Modal;

import java.time.LocalDateTime;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable = false)
		private String name;
	
	@Column(nullable = false , length =30)
private String gender;
	
	@Column(nullable = false , unique = true)
	private String email;
	
	@Column(nullable = false , length=12)
private String contactNo;
	
	@Column(nullable = false  )
private String password;
	
	@Column(nullable = false)
private String collegeName;
	
	@Column(nullable =false)
private String course;

@Column(nullable = false)
private String branch;

@Column(nullable = false)
private String year ;

@Column(nullable = false , unique = true)
private String aadharNo ;
private String dob;

@Column(nullable = false)
private boolean loginStatus;
private LocalDateTime registeredAt;
private String profilePic;
private boolean deleted;

private String otp;
private LocalDateTime generatedAt;

@Enumerated(EnumType.STRING)
@Column(nullable = false)
private UserRole role;

@Enumerated(EnumType.STRING)
@Column(nullable = false)
private UserStatus status;

public enum UserRole{
	ADMIN , STUDENT
}
public enum UserStatus{
	VERFIED , BLOCKED , PENDING
}
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getContactNo() {
	return contactNo;
}
public void setContactNo(String contactNo) {
	this.contactNo = contactNo;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getCollegeName() {
	return collegeName;
}
public void setCollegeName(String collegeName) {
	this.collegeName = collegeName;
}
public String getCourse() {
	return course;
}
public void setCourse(String course) {
	this.course = course;
}
public String getBranch() {
	return branch;
}
public void setBranch(String branch) {
	this.branch = branch;
}
public String getYear() {
	return year;
}
public void setYear(String year) {
	this.year = year;
}
public String getAadharNo() {
	return aadharNo;
}
public void setAadharNo(String aadharNo) {
	this.aadharNo = aadharNo;
}
public String getDob() {
	return dob;
}
public void setDob(String dob) {
	this.dob = dob;
}
public boolean isLoginStatus() {
	return loginStatus;
}
public void setLoginStatus(boolean loginStatus) {
	this.loginStatus = loginStatus;
}
public LocalDateTime getRegisteredAt() {
	return registeredAt;
}
public void setRegisteredAt(LocalDateTime registeredAt) {
	this.registeredAt = registeredAt;
}
public String getProfilePic() {
	return profilePic;
}
public void setProfilePic(String profilePic) {
	this.profilePic = profilePic;
}
public boolean isDeleted() {
	return deleted;
}
public void setDeleted(boolean deleted) {
	this.deleted = deleted;
}
public UserRole getRole() {
	return role;
}
public void setRole(UserRole role) {
	this.role = role;
}
public UserStatus getStatus() {
	return status;
}
public void setStatus(UserStatus status) {
	this.status = status;
}
public String getOtp() {
	return otp;
}
public void setOtp(String otp) {
	this.otp = otp;
}
public LocalDateTime getGeneratedAt() {
	return generatedAt;
}
public void setGeneratedAt(LocalDateTime generatedAt) {
	this.generatedAt = generatedAt;
}

}


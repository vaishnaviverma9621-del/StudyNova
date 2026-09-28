package com.project.StudyNova.Service;

import java.security.SecureRandom;
import java.time.Duration;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.StudyNova.DTO.UserDto;
import com.project.StudyNova.Modal.Users;
import com.project.StudyNova.Modal.Users.UserRole;
import com.project.StudyNova.Modal.Users.UserStatus;
import com.project.StudyNova.Repository.UserRepo;

import jakarta.mail.MessagingException;

@Service
public class UserService {

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private SendEmailService sendEmailService;

	public boolean saveUser(UserDto dto) {
		try {
			if (userRepo.existsByEmail(dto.getEmail())) {
				throw new RuntimeException("User already exists!!!");

			}

			Users user = new Users();
			user.setName(dto.getName());
			user.setEmail(dto.getEmail());
			user.setContactNo(dto.getContactNo());
			user.setGender(dto.getGender());
			user.setAadharNo(dto.getAadharNo());
			user.setCollegeName(dto.getCollegeName());
			user.setCourse(dto.getCourse());
			user.setBranch(dto.getBranch());
			user.setYear(dto.getYear());
			user.setDob(dto.getDob());
			user.setPassword(dto.getPassword());

			user.setDeleted(false);
			user.setLoginStatus(false);
			user.setRole(UserRole.STUDENT);
			user.setStatus(UserStatus.PENDING);
			user.setRegisteredAt(LocalDateTime.now());

			String otp = generateOtp();
			user.setOtp(otp);
			user.setGeneratedAt(LocalDateTime.now());
			userRepo.save(user);

			sendEmailService.sendOtpMail(true, user);
			System.err.println("OTP :" + otp);

			return true;

		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());

		}

	}

	public String generateOtp() {
		SecureRandom random = new SecureRandom();
		String otp = 100000 + random.nextInt(900000) + "";
		return otp;
	}

	public boolean verifyOtp(String otp, Users user) {
		try {
			if (user == null) {
				throw new RuntimeException("User null");
			}
			if (!otp.equals(user.getOtp())) {
				throw new RuntimeException("Invalid Otp");
			}
			long minutes = Duration.between(user.getGeneratedAt(), LocalDateTime.now()).toMinutes();
			if (minutes >= 10) {
				throw new RuntimeException("Expired Otp");
			}
			user.setStatus(UserStatus.VERFIED);
			userRepo.save(user);
			return true;

		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}

	}

	public void resendOtp(Users user) throws MessagingException {
		String otp = generateOtp();

		user.setOtp(otp);
		user.setGeneratedAt(LocalDateTime.now());
		userRepo.save(user);

		// send on mail
		sendEmailService.sendOtpMail(false, user);
		System.err.println("Resend OTP :" + otp);
	}

}

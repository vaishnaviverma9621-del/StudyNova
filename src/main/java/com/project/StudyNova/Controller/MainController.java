package com.project.StudyNova.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project.StudyNova.DTO.UserDto;
import com.project.StudyNova.Modal.Users;
import com.project.StudyNova.Modal.Users.UserRole;
import com.project.StudyNova.Modal.Users.UserStatus;
import com.project.StudyNova.Repository.UserRepo;
import com.project.StudyNova.Service.UserService;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class MainController {

	@Autowired
	private UserService userService;

	@Autowired
	private HttpSession session;

	@Autowired
	private UserRepo userRepo;

	@GetMapping("/")
	public String index() {
		return "index";
	}

	@GetMapping("/AboutUs") // request
	public String showAboutPage() {
		return "about"; // filename
	}

	@GetMapping("/Services")
	public String showServicesPage() {
		return "services";
	}

	@GetMapping("/ContactUs")
	public String showContactPage() {
		return "contact";
	}

	@GetMapping("/login")
	public String loginPage() {
		return "login";
	}
	@PostMapping("/login")
	public String loginpage(HttpServletRequest request , RedirectAttributes attributes) {
		try {String username = request.getParameter("username");
			String password = request.getParameter("password");
			
			if (!userRepo.existsByEmail(username)) {
				attributes.addFlashAttribute("msg", "user not found");
				return "redirect:/login";
			}
			
			Users user = userRepo.findByEmail(username);
			
			if (!password.equals(user.getPassword())) {
				attributes.addFlashAttribute("msg","invalid user or password");
				return "redirect:/login";
			}
			
			if (user.isDeleted()) {
				attributes.addFlashAttribute("msg","Id deactivated , please contact admin!");
				return "redirect:/login";
			}
			
			if (user.getRole().equals(UserRole.STUDENT)) {
				//student dashboard
				if (user.getStatus().equals(UserStatus.PENDING)) {
					userService.resendOtp(user);
					session.setAttribute("email", user.getEmail());
					attributes.addFlashAttribute("msg","please complete verification first!!");
					return "redirect:/verify-otp";
				}else if(user.getStatus().equals(UserStatus.BLOCKED)){
					 attributes.addFlashAttribute("msg","login disabled , please contact studynova");
					 return"redirect:/login";
					
				}
				else {
					session.setAttribute("loggedInStudent", user);
					return "redirect:/Student/Dashboard";
				}
			}
			else {
				//admin dashboard
				session.setAttribute("loggedInAdmin", user);
				return "redirect:/Admin/Dashboard";
			}
		} catch (Exception e) {
		}
		return "redirect:/login ";
	}

	@GetMapping("/Registration")
	public String showRegistrationPage(Model model) {
		UserDto userDto = new UserDto();
		model.addAttribute("userDto ", userDto);
		return "register";
	}

	@PostMapping("/Register")
	public String UserRegistration(@ModelAttribute("userDto") UserDto dto, RedirectAttributes attributes) {
		try {
			boolean status = userService.saveUser(dto);
			if (status == true) {

				attributes.addFlashAttribute("msg", "Registration completed, please verify otp!!");
				session.setAttribute("email", dto.getEmail());
				return "redirect:/verify-otp";
			}
		} catch (Exception e) {
			attributes.addFlashAttribute("msg", e.getMessage());
		}
		return "redirect:/Registration";
	}

	@GetMapping("/verify-otp")
	public String verifyOtpPage() {

		if (session.getAttribute("email") == null) {

			return "redirect:/Registration";
		}
		return "verifyOtp";
	}

	@PostMapping("/verify-otp")
	public String verfiyOtp(@RequestParam("otp") String otp, RedirectAttributes attributes) {
		try {
			String email = (String) session.getAttribute("email");
			Users users = userRepo.findByEmail(email);

			boolean status = userService.verifyOtp(otp, users);
			if (status == true) {
				attributes.addFlashAttribute("msg", "Otp verification successful , registration completed");
				return "redirect:/Login";
			}
		} catch (Exception e) {

			attributes.addFlashAttribute("msg", e.getMessage());
		}
		return "redirect:/verify-otp";
	}

	@GetMapping("/resend-otp")
	public String resendOtp(RedirectAttributes attributes) {

		try {
			String email = (String) session.getAttribute("email");
			Users user = userRepo.findByEmail(email);

			userService.resendOtp(user);

		} catch (Exception e) {
			attributes.addFlashAttribute("msg", e.getMessage());

		}
		return "redirect:/verify-otp";
	}
	@GetMapping("/Student/Logout")
	public String studentLogout(HttpSession session) {

	    session.removeAttribute("loggedInStudent");

	    return "redirect:/login";
	}
}

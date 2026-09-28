package com.project.StudyNova.Controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.project.StudyNova.Modal.Contact;
import com.project.StudyNova.Modal.Users;
import com.project.StudyNova.Repository.ContactRepo;
import com.project.StudyNova.Repository.UserRepo;

import jakarta.servlet.http.HttpSession;

@Controller
public class AdminController {

    private final UserRepo userRepo;
    private final ContactRepo contactRepo;

    public AdminController(UserRepo userRepo, ContactRepo contactRepo) {
        this.userRepo = userRepo;
        this.contactRepo = contactRepo;
    }

    @GetMapping("/Admin/Dashboard")
    public String adminDashboard(HttpSession session, Model model) {

        Users admin = (Users) session.getAttribute("loggedInAdmin");

        if (admin == null || admin.getRole() != Users.UserRole.ADMIN) {
            return "redirect:/login";
        }

        long totalUsers = userRepo.count();
        long totalContacts = contactRepo.count();

        int totalCourses = 6;

        model.addAttribute("totalUsers", totalUsers);
        model.addAttribute("totalContacts", totalContacts);
        model.addAttribute("totalCourses", totalCourses);
        model.addAttribute("totalUsers", totalUsers);

        return "admin-dashboard";
    }
    @GetMapping("/Admin/Users")
    public String adminUsers(HttpSession session, Model model) {

        Users admin = (Users) session.getAttribute("loggedInAdmin");

        if (admin == null || admin.getRole() != Users.UserRole.ADMIN) {
            return "redirect:/login";
        }

        List<Users> students =
                userRepo.findByRole(Users.UserRole.STUDENT);

        model.addAttribute("students", students);

        return "admin-users";
    }
    @GetMapping("/Admin/Users/Block/{id}")
    public String blockUser(
            @PathVariable Long id,
            HttpSession session) {

        Users admin = (Users) session.getAttribute("loggedInAdmin");

        if (admin == null || admin.getRole() != Users.UserRole.ADMIN) {
            return "redirect:/login";
        }

        Users student = userRepo.findById(id).orElse(null);

        if (student != null) {
            student.setStatus(Users.UserStatus.BLOCKED);
            userRepo.save(student);
        }

        return "redirect:/Admin/Users";
    }
    @GetMapping("/Admin/Users/Unblock/{id}")
    public String unblockUser(
            @PathVariable Long id,
            HttpSession session) {

        Users admin = (Users) session.getAttribute("loggedInAdmin");

        if (admin == null || admin.getRole() != Users.UserRole.ADMIN) {
            return "redirect:/login";
        }

        Users student = userRepo.findById(id).orElse(null);

        if (student != null) {
            student.setStatus(Users.UserStatus.VERFIED);
            userRepo.save(student);
        }

        return "redirect:/Admin/Users";
    }
    @GetMapping("/Admin/Contacts")
    public String adminContacts(HttpSession session, Model model) {

        Users admin = (Users) session.getAttribute("loggedInAdmin");

        if (admin == null || admin.getRole() != Users.UserRole.ADMIN) {
            return "redirect:/login";
        }

        List<Contact> contacts = contactRepo.findAll();

        model.addAttribute("contacts", contacts);

        return "admin-contacts";
    }
    @GetMapping("/Admin/Contacts/Delete/{id}")
    public String deleteContact(
            @PathVariable Long id,
            HttpSession session) {

        Users admin = (Users) session.getAttribute("loggedInAdmin");

        if (admin == null || admin.getRole() != Users.UserRole.ADMIN) {
            return "redirect:/login";
        }

        contactRepo.deleteById(id);

        return "redirect:/Admin/Contacts";
    }
    @GetMapping("/Admin/Logout")
    public String adminLogout(HttpSession session) {

        session.removeAttribute("loggedInAdmin");

        return "redirect:/login";
    }
}
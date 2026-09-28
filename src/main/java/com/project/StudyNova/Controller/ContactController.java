package com.project.StudyNova.Controller;

import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project.StudyNova.Modal.Contact;
import com.project.StudyNova.Repository.ContactRepo;

@Controller
public class ContactController {

    private final ContactRepo contactRepo;

    public ContactController(ContactRepo contactRepo) {
        this.contactRepo = contactRepo;
    }
    @GetMapping("/contact")
    public String contactPage() {
        return "contact";
    }
    @PostMapping("/contact")
    public String submitContact(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String course,
            @RequestParam String message,
            RedirectAttributes redirectAttributes) {

        Contact contact = new Contact();

        contact.setName(name);
        contact.setEmail(email);
        contact.setCourse(course);
        contact.setMessage(message);
        contact.setSubmittedAt(LocalDateTime.now());

        contactRepo.save(contact);

        redirectAttributes.addFlashAttribute(
                "successMessage",
                "Your message has been sent successfully! 🎉"
        );

        return "redirect:/contact";
    }
}
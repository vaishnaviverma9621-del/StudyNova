package com.project.StudyNova.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.project.StudyNova.Modal.Users;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class SendEmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendOtpMail(boolean isRegister, Users user) throws MessagingException {

        String subject;

        if (isRegister) {
            subject = "Verify Your Email Address - StudyNova OTP Code";
        } else {
            subject = "Your New StudyNova OTP Code (Previous Code Expired)";
        }

        String message =
                "<!DOCTYPE html>"
                + "<html lang=\"en\">"
                + "<head>"
                + "<meta charset=\"UTF-8\">"
                + "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">"
                + "<title>StudyNova OTP Verification</title>"
                + "</head>"

                + "<body style=\"margin:0;padding:0;background:#f4f7fb;font-family:Arial,Helvetica,sans-serif;\">"

                + "<table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" "
                + "style=\"background:#f4f7fb;padding:40px 15px;\">"

                + "<tr><td align=\"center\">"

                + "<table width=\"600\" cellpadding=\"0\" cellspacing=\"0\" "
                + "style=\"background:#ffffff;border-radius:16px;overflow:hidden;\">"

                + "<tr>"
                + "<td align=\"center\" style=\"background:#2563eb;padding:40px;color:white;\">"
                + "<h1 style=\"margin:0;font-size:32px;\">StudyNova</h1>"
                + "<p style=\"margin-top:10px;font-size:16px;\">Smart Learning Platform</p>"
                + "</td>"
                + "</tr>"

                + "<tr>"
                + "<td style=\"padding:40px;\">"

                + "<h2 style=\"margin-top:0;color:#1f2937;\">"
                + "Hello " + user.getName() + ","
                + "</h2>"

                + "<p style=\"font-size:16px;color:#555;line-height:28px;\">"
                + "Welcome to <strong>StudyNova</strong>! "
                + "To complete your registration, please verify your email address "
                + "using the One-Time Password (OTP) below."
                + "</p>"

                + "<div style=\"margin:35px auto;background:#eef4ff;"
                + "border:2px dashed #2563eb;border-radius:12px;"
                + "padding:20px;text-align:center;\">"

                + "<p style=\"margin:0;color:#666;font-size:14px;\">"
                + "Your Verification Code"
                + "</p>"

                + "<h1 style=\"margin:12px 0;font-size:42px;"
                + "letter-spacing:10px;color:#2563eb;\">"
                + user.getOtp()
                + "</h1>"

                + "<p style=\"margin:0;color:#888;\">"
                + "Valid for <strong>10 Minutes</strong>"
                + "</p>"

                + "</div>"

                + "<p style=\"font-size:15px;color:#666;line-height:26px;\">"
                + "For your security, never share this OTP with anyone. "
                + "StudyNova will never ask you for your OTP via phone, email, or message."
                + "</p>"

                + "<hr style=\"border:none;border-top:1px solid #eee;margin:35px 0;\">"

                + "<p style=\"font-size:14px;color:#777;line-height:24px;\">"
                + "If you didn't create an account on StudyNova, "
                + "please ignore this email. No further action is required."
                + "</p>"

                + "</td>"
                + "</tr>"

                + "<tr>"
                + "<td style=\"background:#f8fafc;padding:30px;text-align:center;"
                + "font-size:13px;color:#888;\">"

                + "<strong style=\"font-size:18px;color:#2563eb;\">StudyNova</strong>"
                + "<br><br>"
                + "Empowering Learning Through Technology"
                + "<br><br>"
                + "© " + java.time.Year.now().getValue()
                + " StudyNova. All Rights Reserved."

                + "</td>"
                + "</tr>"

                + "</table>"
                + "</td></tr>"
                + "</table>"

                + "</body>"
                + "</html>";

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();

        MimeMessageHelper helper =
                new MimeMessageHelper(mimeMessage, true);

        helper.setTo(user.getEmail());
        helper.setSubject(subject);
        helper.setText(message, true);

        helper.setFrom("vaishnaviverma9621@gmail.com");

        javaMailSender.send(mimeMessage);
    }
}
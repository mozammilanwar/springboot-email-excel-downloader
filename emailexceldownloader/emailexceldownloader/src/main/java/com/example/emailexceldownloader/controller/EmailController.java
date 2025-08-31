package com.example.emailexceldownloader.controller;

import com.example.emailexceldownloader.service.EmailService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmailController {

    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/download-excel")
    public String downloadExcel(Model model) {
        String message = emailService.downloadLatestExcel();
        model.addAttribute("message", message);
        return "index";
    }
}

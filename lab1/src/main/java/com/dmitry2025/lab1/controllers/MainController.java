package com.dmitry2025.lab1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.SecureRandom;
import java.util.Map;

@Controller
@RequestMapping("/api")
public class MainController {
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final SecureRandom random = new SecureRandom();

    @GetMapping("/service-mail-p")
    public String serviceMailP(Model model) {
        model.addAttribute("mail", "789test897@gmail.com");
        return "main";
    }

    @GetMapping("/service-mail")
    @ResponseBody
    public Map<String, String> serviceMail() {
        return Map.of("mail", "789test897@gmail.com");
    }

    @GetMapping("/parse-mail-p")
    public String parseMailP(
            Model model,
            @RequestParam("mail") String mail
    ) {
        var delimiter = "@";
        var domen = mail.substring(mail.indexOf(delimiter) + 1);
        var login = mail.substring(0, mail.indexOf(delimiter));
        model.addAttribute("domen", domen);
        model.addAttribute("login", login);
        return "parse";
    }

    @GetMapping("/parse-mail")
    @ResponseBody
    public Map<String, String> parseMail(
            @RequestParam("mail") String mail
    ) {
        var delimiter = "@";
        var domen = mail.substring(mail.indexOf(delimiter) + 1);
        var login = mail.substring(0, mail.indexOf(delimiter));
        return Map.of("domen", domen, "login", login);
    }

    @GetMapping("/gen-mail-p")
    public String genMailP(Model model) {
        var domen = "@isa.utm.md";
        var login = generateRandomString(8);
        model.addAttribute("mail", login+domen);
        return "gen";
    }

    @GetMapping("/gen-mail")
    @ResponseBody
    public Map<String, String> genMail() {
        var domen = "@isa.utm.md";
        var login = generateRandomString(8);
        return Map.of("mail", login+domen);
    }


    private static String generateRandomString(int length) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(CHARACTERS.charAt(random.nextInt(CHARACTERS.length())));
        }
        return sb.toString();
    }
}

package org.launchcode.controllers;

import org.launchcode.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {

    @RequestMapping(value = "login")
    public String index() {
        return "etc/login";
    }
    @RequestMapping(value = "signup", method = RequestMethod.GET)
    public String signup() {
        return "etc/signup";
    }

    @RequestMapping(value = "signup", method = RequestMethod.POST)
    public String add(Model model, @ModelAttribute User user, String verify_password) {
        model.addAttribute("user", user);

        if (user.getPassword().equals(verify_password)) {
            return "etc/index";
        }

        model.addAttribute("error_message", "I'm sorry, but password doesn't match verify password. Please try again.");
        return "etc/signup";
    }

}


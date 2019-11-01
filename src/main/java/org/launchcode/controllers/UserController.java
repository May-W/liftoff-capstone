package org.launchcode.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    @RequestMapping(value = "login")
    public String index() {
        return "etc/login";
    }
    @RequestMapping(value = "signup")
    public String signup() {
        return "etc/signup";
    }


}


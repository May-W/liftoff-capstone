package org.launchcode.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ConsoleController {

    @RequestMapping(value = "home")
    public String index() {
        return "etc/index";
    }

    @RequestMapping(value = "addconsole")
    public String addconsole() {
        return "consoles/add";
    }
}

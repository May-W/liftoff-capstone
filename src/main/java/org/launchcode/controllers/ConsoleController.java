package org.launchcode.controllers;

import org.launchcode.models.Console;
import org.launchcode.models.data.ConsoleDao;
import org.launchcode.models.data.GameDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping(value = "consoles")
@Controller
public class ConsoleController {

    @Autowired
    ConsoleDao consoleDao;

    @Autowired
    GameDao gameDao;

    //TODO i need a homepage which is a list of all consoles and i can select one... and an add consoles form. These need to be seperate.

    @RequestMapping(value = "")
    public String index(Model model) {
        model.addAttribute("title", "Consoles");
        model.addAttribute("consoles", ConsoleDao.findAll());
        return "consoles/consoles";
    }

    @RequestMapping(value = "home")
    public String index() {
        return "etc/index";
    }

    @RequestMapping(value = "addconsole")
    public String addconsole() {
        return "consoles/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute("title", "Add Console");
        model.addAttribute(new Console());
        return "add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(Model model, @ModelAttribute @Valid Console console, Errors errors) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Menu");
            return "add";
        }
        consoleDao.save(console);

        return "redirect:consoles/" + console.getId();
    }

    @RequestMapping(value = "/view/{consoleId}", method = RequestMethod.GET)
    public String viewConsole(Model model, @PathVariable int consoleId) {
        Console console = ConsoleDao.findOne(consoleId);
        model.addAttribute("brand", console.getBrand());
        model.addAttribute("title", console.getName());
        model.addAttribute("games", console.getGames());
        model.addAttribute("consoleId", console.getId());

        return "consoles/consoles";
    }


}

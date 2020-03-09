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

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("title", "My Consoles");
        model.addAttribute("consoles", consoleDao.findAll());
        return "consoles/consoles";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute("title", "Add a console to your collection!");
        model.addAttribute(new Console());
        return "consoles/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(Model model, @ModelAttribute @Valid Console console, Errors errors) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add a console to your collection!");
            return "add";
        }
        consoleDao.save(console);

        return "redirect:/consoles/";
    }

    @RequestMapping(value = "/view/{consoleId}", method = RequestMethod.GET)
    public String viewConsole(Model model, @PathVariable int consoleId) {
        Console console = consoleDao.findById(consoleId).get();
        model.addAttribute("brand", console.getBrand());
        model.addAttribute("title", console.getName());
        model.addAttribute("games", console.getGames());
        model.addAttribute("consoleId", console.getId());

        return "games/index";
    }


}

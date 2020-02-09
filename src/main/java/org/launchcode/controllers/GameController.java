package org.launchcode.controllers;

import org.launchcode.models.Console;
import org.launchcode.models.Game;
import org.launchcode.models.data.ConsoleDao;
import org.launchcode.models.data.GameDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import javax.validation.Valid;
import java.util.Locale;

@Controller
@RequestMapping("game")
public class GameController {

    @Autowired
    private GameDao gameDao;

    @Autowired
    ConsoleDao consoleDao;

    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("games", gameDao.findAll());
        model.addAttribute("title", "My Games");

        return "games/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddGameForm(Model model) {
        model.addAttribute("title", "Add Game");
        model.addAttribute(new Game());
        model.addAttribute("categories", gameDao.findAll());
        return "games/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddGameForm(@ModelAttribute  @Valid Game newGame,
                                       Errors errors, @RequestParam int consoleId, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Cheese");
            model.addAttribute("categories", consoleDao.findAll());
            return "game/add";
        }
        Console console = consoleDao.findById(consoleId).get();
        newGame.setConsole(console);
        gameDao.save(newGame);
        return "redirect:";
    }

    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public String displayRemoveGameForm(Model model) {
        model.addAttribute("game", gameDao.findAll());
        model.addAttribute("title", "Remove Game");
        return "cheese/remove";
    }

    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String processRemoveGameForm(@RequestParam int[] gameIds) {

        for (int gameId : gameIds) {
            gameDao.deleteById(gameId);
        }

        return "redirect:";
    }


}

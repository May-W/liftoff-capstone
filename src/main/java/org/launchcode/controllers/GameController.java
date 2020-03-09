package org.launchcode.controllers;

import org.launchcode.models.Console;
import org.launchcode.models.Game;
import org.launchcode.models.data.ConsoleDao;
import org.launchcode.models.data.GameDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

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
        model.addAttribute("title", "Games");

        return "games/index";
    }

    @RequestMapping(value = "add/{consoleId}", method = RequestMethod.GET)
    public String displayAddGameForm(Model model) {
        model.addAttribute("title", "Add Game");
        model.addAttribute(new Game());
        model.addAttribute("categories", gameDao.findAll());
        return "games/add";
    }

    @RequestMapping(value = "add/{consoleId}", method = RequestMethod.POST)
    public String processAddGameForm(@ModelAttribute  @Valid Game newGame,
                                       Errors errors, @PathVariable int consoleId, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add game");
            return "game/add";
        }
        Console console = consoleDao.findById(consoleId).get();
        newGame.setConsole(console);
        gameDao.save(newGame);
        return "redirect:/consoles/";
    }
//TODO - the above redirects to home temporarily. I need this to redirect to "add/{consoleId}" but i need to research the correct syntax

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
//    @RequestMapping(value = "/view/{consoleId}", method = RequestMethod.GET)
//   public String viewConsole(Model model, @PathVariable int consoleId) {
//        Game game = gameDao.findById(consoleId).get();
//        model.addAttribute("title", game.getName());
//        return "games/view";
//    }


}

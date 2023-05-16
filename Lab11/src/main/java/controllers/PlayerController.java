package controllers;


import models.Player;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/players")
public class PlayerController {

    List<Player> players;

    @RequestMapping(value = "all", method = RequestMethod.GET)
    public List<Player> getPlayers () {
        players = new ArrayList<>();
        players.add(new Player("Ana"));
        players.add(new Player("Ion"));
        return players;
    }
}

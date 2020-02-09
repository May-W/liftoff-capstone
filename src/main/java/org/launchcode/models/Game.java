package org.launchcode.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class Game {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    private String name;

    private String synopsis;

    private String imageURL;

    @OneToOne(mappedBy = "games")
    private Console console;

    public Game(String name, String synopsis, String imageURL, Console consoles) {
        this.name = name;
        this.synopsis = synopsis;
        this.imageURL = imageURL;
        this.console = console;
    }

    public Game() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public Console getConsoles() {
        return console;
    }

    public void setConsole(Console consoles) {
        this.console = consoles;
    }


}

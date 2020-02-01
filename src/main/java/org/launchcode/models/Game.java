package org.launchcode.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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

    @ManyToMany(mappedBy = "games")
    private List<Console> consoles;

    public Game(String name, String synopsis, String imageURL, List<Console> consoles) {
        this.name = name;
        this.synopsis = synopsis;
        this.imageURL = imageURL;
        this.consoles = consoles;
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


}

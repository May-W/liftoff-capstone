package org.launchcode.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Console {
    @Id
    @GeneratedValue
    private int id;

    @NotNull
    private String name;

    @OneToMany
    @JoinColumn(name = "id")
    private List<Game> games;
            //= new ArrayList<>();

    @NotNull
    private String brand;

    public Console(@NotNull String name, @NotNull String brand) {
        this.name = name;
        this.brand = brand;
    }

    public Console() {
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

    public List<Game> getGames() {
        return games;
    }

    public void addGames(Game game) {
        games.add(game);
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}

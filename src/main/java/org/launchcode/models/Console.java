package org.launchcode.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;


@Entity
public class Console {
    @Id
    @GeneratedValue
    private int id;

    @NotNull
    private String name;

    @OneToMany(mappedBy="console")
    private Set<Game> games;
            //= new ArrayList<>();

    //TODO - according to research this might need to be a Set and not a List?

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

    public Set<Game> getGames() {
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

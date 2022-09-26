package com.apipokemon.apipokemon.model;

import javax.persistence.*;
import java.util.List;

public class Player {

    @Column(name = "name")
    private String name;
    @Column(name = "age")
    private Integer age;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "tb_player_pokemon",
            joinColumns        = @JoinColumn(name = "id_player", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "id_pokemon", referencedColumnName = "id")
    )
    private List<Pokemon> pokemons;
}

package com.apipokemon.apipokemon.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity @Data
@AllArgsConstructor @NoArgsConstructor
public class Pokemon {

    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "tb_pokemon_type",
            joinColumns        = @JoinColumn(name = "id_pokemon", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "id_telefone", referencedColumnName = "id")
    )
    private List<Type> types;

    @Column(name = "tipoUm")
    private Long tipoUm;
    @Column(name = "tipoDois")
    private Long tipoDois;


}

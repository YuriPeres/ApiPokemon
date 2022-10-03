package com.apipokemon.apipokemon.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity()
@Table(name = "tb_pokemon")
@Data
@AllArgsConstructor @NoArgsConstructor
public class Pokemon {

    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;

    @ManyToMany()
    @JoinTable(
            name = "tb_pokemon_tipo",
            joinColumns        = {@JoinColumn(name = "id_pokemon", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "id_tipo", referencedColumnName = "id")}
    )
    private List<Type> types;



}

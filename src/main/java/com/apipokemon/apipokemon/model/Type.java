package com.apipokemon.apipokemon.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "tb_type")
public class Type {

    @Id
    @Column(name = "id")
    private Long id;

    @ManyToMany(mappedBy = "types")
    private List<Pokemon> pokemons;



}

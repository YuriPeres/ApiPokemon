package com.apipokemon.apipokemon.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.util.List;

@Entity @Data
@AllArgsConstructor @NoArgsConstructor
public class Pokemon {

    @Id @Column(name = "id")
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
}

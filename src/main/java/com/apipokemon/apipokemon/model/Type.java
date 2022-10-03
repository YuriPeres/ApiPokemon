package com.apipokemon.apipokemon.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity()
@Table(name = "tb_tipo")
public class Type {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

//    @ManyToMany(mappedBy = "types") @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
//    private List<Pokemon> pokemons;

}

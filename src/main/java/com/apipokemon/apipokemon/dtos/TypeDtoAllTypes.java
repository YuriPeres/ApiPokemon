package com.apipokemon.apipokemon.dtos;

import com.apipokemon.apipokemon.model.Type;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TypeDtoAllTypes {

    private Long id;
    private String name;

//    private List<PokemonDto> pokemons;

    public TypeDtoAllTypes(Type tipo) {
        this.id = tipo.getId();
        this.name = tipo.getName();
    }
}

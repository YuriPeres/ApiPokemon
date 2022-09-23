package com.apipokemon.apipokemon.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PokemonDto {

    private Long id;
    private String name;
    private String url;

}

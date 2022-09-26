package com.apipokemon.apipokemon.dtos;

import com.apipokemon.apipokemon.model.Type;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PokemonDto {

    private Long id;
    private String name;
    private List<TypeDto> types;




}

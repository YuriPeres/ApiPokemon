package com.apipokemon.apipokemon.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TypeRelationsDto {

    private Long id;
    private ArrayList<String> forteContra;
    private ArrayList<String> fracoFraco;


}

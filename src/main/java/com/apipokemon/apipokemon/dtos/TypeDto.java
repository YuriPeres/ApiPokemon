package com.apipokemon.apipokemon.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TypeDto {

    private Integer slot;
    private Map<String, String> type;



}

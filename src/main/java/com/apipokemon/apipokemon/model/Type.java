package com.apipokemon.apipokemon.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Type {

    private Long slot;
    private Map<String, String> type;


}

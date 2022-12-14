package com.apipokemon.apipokemon.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TypeDto {

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Long id;
    private Integer slot;
    private Map<String, String> type;




}

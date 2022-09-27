package com.apipokemon.apipokemon.controller;

import com.apipokemon.apipokemon.dtos.PokemonDto;
import com.apipokemon.apipokemon.dtos.TypeRelationsDto;
import com.apipokemon.apipokemon.model.Pokemon;
import com.apipokemon.apipokemon.service.PokemonService;
import com.apipokemon.apipokemon.service.TypeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/tipo")
public class TypeController {


    private final TypeService service;

//    @GetMapping
//    public List<Pokemon> listarPokemons(){
//        return service.listarPokemons();
//    }

    @GetMapping("/relations")
    public TypeRelationsDto getRelations(){

        return service.getAllTypesRelations();
    }

}

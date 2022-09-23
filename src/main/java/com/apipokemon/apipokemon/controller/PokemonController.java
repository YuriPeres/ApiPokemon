package com.apipokemon.apipokemon.controller;

import com.apipokemon.apipokemon.dtos.PokemonDto;
import com.apipokemon.apipokemon.model.Pokedex;
import com.apipokemon.apipokemon.model.Pokemon;
import com.apipokemon.apipokemon.service.PokemonService;
import lombok.AllArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/pokemon")
public class PokemonController {


    private final PokemonService service;

//    @GetMapping
//    public List<Pokemon> listarPokemons(){
//        return service.listarPokemons();
//    }

    @GetMapping("/{idOuNome}")
    @ResponseBody
    public Pokemon buscarPorIdOuNome(@PathVariable String idOuNome){
        UriComponents uri = UriComponentsBuilder.newInstance()
                .scheme("https")
                .host("pokeapi.co/")
                .path("api/v2/pokemon/35")
                //.queryParam("idOuNome","all")
                .build();
        RestTemplate template = new RestTemplate();

        Pokemon pokemon = template.getForObject(uri.toUri(), Pokemon.class);
        System.out.println(pokemon);
        return service.buscarPorIdOuNome(idOuNome);
    }

}

package com.apipokemon.apipokemon.controller;

import com.apipokemon.apipokemon.dtos.PokemonDto;
import com.apipokemon.apipokemon.model.Pokemon;
import com.apipokemon.apipokemon.service.PokemonService;
import lombok.AllArgsConstructor;
import org.apache.tomcat.util.json.ParseException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

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
    public PokemonDto buscarPorIdOuNome(@PathVariable String idOuNome) {
        return service.buscarPorIdOuNome(idOuNome);
    }

}

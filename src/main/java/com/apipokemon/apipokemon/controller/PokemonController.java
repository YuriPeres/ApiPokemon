package com.apipokemon.apipokemon.controller;

import com.apipokemon.apipokemon.dtos.PokemonDto;
import com.apipokemon.apipokemon.model.Pokemon;
import com.apipokemon.apipokemon.service.PokemonService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/pokemon")
public class PokemonController {


    private final PokemonService pokemonService;

//    @GetMapping
//    public List<Pokemon> listarPokemons(){
//        return service.listarPokemons();
//    }

    @GetMapping("/{idOuNome}")
    @ResponseBody
    public PokemonDto buscarPorIdOuNome(@PathVariable String idOuNome) {
        return pokemonService.buscarPorIdOuNome(idOuNome);
    }

    @GetMapping("/save_all")
    public List<Pokemon> saveAllPokemons(){
        return pokemonService.saveAllPokemon();
    }

}

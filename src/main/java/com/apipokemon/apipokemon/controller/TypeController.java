package com.apipokemon.apipokemon.controller;

import com.apipokemon.apipokemon.dtos.TypeDtoAllTypes;
import com.apipokemon.apipokemon.service.TypeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/save_all")
    public List<TypeDtoAllTypes> saveAllTypes(){

        return service.saveAllTypes();
    }

}

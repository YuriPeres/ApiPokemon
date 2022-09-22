package com.apipokemon.apipokemon.service;

import com.apipokemon.apipokemon.model.Pokemon;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@AllArgsConstructor
@Service
@ResponseBody
public class PokemonService {

    void buscarPokemon(){
        RestTemplate template = new RestTemplate();

        //https://pokeapi.co/api/v2/pokemon/35

        UriComponents uri = UriComponentsBuilder.newInstance()
                .scheme("https")
                .host("pokeapi.co/")
                .path("api/v2/")
                .queryParam("pokemon","all")
                .build();

        ResponseEntity<Pokemon> pokemon = template.getForEntity(uri.toUriString(), Pokemon.class);

        System.out.println(pokemon);
        System.out.println(pokemon.getBody().getId());
        System.out.println(pokemon.getBody().getName());
    }
}

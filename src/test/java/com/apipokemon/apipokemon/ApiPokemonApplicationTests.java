package com.apipokemon.apipokemon;

import com.apipokemon.apipokemon.model.Pokemon;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@SpringBootTest
class ApiPokemonApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void consumerApi(){
        RestTemplate template = new RestTemplate();

        //https://pokeapi.co/api/v2/pokemon/35

        UriComponents uri = UriComponentsBuilder.newInstance()
                .scheme("https")
                .host("pokeapi.co/")
                .path("api/v2/pokemon/35")
                .queryParam("pokemon","all")
                .build();

        ResponseEntity<Pokemon> pokemon = template.getForEntity(uri.toUriString(), Pokemon.class);

        System.out.println(pokemon);
        System.out.println(pokemon.getBody().getId());
        System.out.println(pokemon.getBody().getName());
    }

}

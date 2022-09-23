package com.apipokemon.apipokemon;

import com.apipokemon.apipokemon.model.Pokemon;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

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
                .path("api/v2/pokemon")
                //.queryParam("pokemon","all")
                .build();

        ResponseEntity<List<Pokemon>> pokedexLista = template.exchange
                (
                        uri.toUriString(),
                        HttpMethod.GET,
                        null,
                        new ParameterizedTypeReference<List<Pokemon>>() {
                        }
                );

//        System.out.println("---> Pokedex\n" + pokedexLista);
//        System.out.println("---> Pokedex getPokemons\n" + pokedexLista.getBody().get(2));
        System.out.println("---> Pokedex getBody\n" + pokedexLista.getBody());
    }

}

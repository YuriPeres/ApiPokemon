package com.apipokemon.apipokemon.service;

import com.apipokemon.apipokemon.dtos.PokemonDto;
import com.apipokemon.apipokemon.dtos.TypeDto;
import com.apipokemon.apipokemon.model.Pokedex;
import com.apipokemon.apipokemon.model.Pokemon;
import com.apipokemon.apipokemon.model.Type;
import lombok.AllArgsConstructor;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Service
@ResponseBody
public class PokemonService {

    private UriComponents uri;  //https://pokeapi.co/api/v2/pokemon/35
    private RestTemplate template;

    public PokemonService() {
        this.uri = UriComponentsBuilder.newInstance()
                .scheme("https")
                .host("pokeapi.co/")
                .path("api/v2/pokemon")
                //.queryParam("idOuNome","all")
                .build();
        this.template = new RestTemplateBuilder()
                .rootUri(uri.toUriString())
                .build();
    }

//    @Transactional
//    public List<Pokemon> listarPokemons() {
//        ResponseEntity<List<Pokemon>> pokedexLista = template.exchange
//                (
//                        uri.toUriString(),
//                        HttpMethod.GET,
//                        null,
//                        new ParameterizedTypeReference<List<Pokemon>>() {
//                        }
//                );
//
//        System.out.println("---> Pokedex\n" + pokedexLista);
//        System.out.println("---> Pokedex getPokemons\n" + pokedexLista.getBody().get(2));
//        System.out.println("---> Pokedex getBody\n" + pokedexLista.getBody());
//        return pokedexLista.getBody();
//    }

    @Transactional
    public PokemonDto buscarPorIdOuNome(String idOuNome) {
        Pokemon pokemon = new Pokemon();
        PokemonDto dto = template.getForObject("/{idOuNome}", PokemonDto.class,idOuNome);
        pokemon.setId(dto.getId());
        pokemon.setName(dto.getName());
        List<String> listaTipos= new ArrayList<>();
        for (TypeDto elementoListaTipos: dto.getTypes()){
            for (String linha: elementoListaTipos.getType().values()){
                if(linha.contains("https")){
                    listaTipos.add(linha);
                    System.out.println("Entrou aqui");
                }
                System.out.println("Fora: "+ linha);
            }
        }
        System.out.println("Lista tipos: "+listaTipos);



        return dto;
    }

}

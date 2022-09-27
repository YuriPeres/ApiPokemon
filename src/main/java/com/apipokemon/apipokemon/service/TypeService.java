package com.apipokemon.apipokemon.service;

import com.apipokemon.apipokemon.dtos.PokemonDto;
import com.apipokemon.apipokemon.dtos.TypeDto;
import com.apipokemon.apipokemon.dtos.TypeRelationsDto;
import com.apipokemon.apipokemon.model.Pokemon;
import com.apipokemon.apipokemon.repository.TypeRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
@Service
@ResponseBody
public class TypeService {

    private UriComponents uri;  //https://pokeapi.co/api/v2/type/12
    private RestTemplate template;

    private TypeRepository typeRepository;

    public TypeService() {
        this.uri = UriComponentsBuilder.newInstance()
                .scheme("https")
                .host("pokeapi.co/")
                .path("api/v2/")
                //.queryParam("idOuNome","all")
                .build();
        this.template = new RestTemplateBuilder()
                .rootUri(uri.toUriString())
                .build();
    }


    @Transactional
    public TypeRelationsDto getAllTypesRelations() {

        TypeRelationsDto dto = template.getForObject("/type/grass", TypeRelationsDto.class);
        return dto;
    }
}

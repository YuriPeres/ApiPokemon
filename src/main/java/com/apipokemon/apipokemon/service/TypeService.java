package com.apipokemon.apipokemon.service;

import com.apipokemon.apipokemon.dtos.TypeDtoAllTypes;
import com.apipokemon.apipokemon.model.Type;
import com.apipokemon.apipokemon.repository.TypeRepository;
import lombok.AllArgsConstructor;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
@ResponseBody
public class TypeService {

    //Exemplo: https://pokeapi.co/api/v2/type/12
    private final UriComponents uri = UriComponentsBuilder.newInstance()
            .scheme("https")
            .host("pokeapi.co/")
            .path("api/v2/")
            //.queryParam("idOuNome","all")
            .build();

    private final RestTemplate template = new RestTemplateBuilder()
            .rootUri(uri.toUriString())
            .build();

    private final TypeRepository typeRepository;





    @Transactional
    public List<TypeDtoAllTypes> saveAllTypes() {
        String jString = template.getForObject("/type/", String.class);
        JSONObject jObj = new JSONObject(jString);
        JSONArray jArrTypes = jObj.getJSONArray("results");
        for(int i = 0; i < jArrTypes.length(); i++){
            JSONObject elementoArr = jArrTypes.getJSONObject(i);
            Type tipo = new Type();
            tipo.setName(elementoArr.getString("name"));
            String idString = elementoArr.getString("url")
                    .substring(30).replace("/", "");
            tipo.setId(Long.parseLong(idString));
            typeRepository.save(tipo);
        }


        return converterTypeParaDto(typeRepository.findAll());
    }


    private List<TypeDtoAllTypes> converterTypeParaDto(List<Type> tipos){
        List<TypeDtoAllTypes> dtos = new ArrayList<>();
        for (Type elemento: tipos) {
            dtos.add(new TypeDtoAllTypes(elemento));
        }

        return dtos;
    }
}

package com.apipokemon.apipokemon.service;

import com.apipokemon.apipokemon.dtos.PokemonDto;
import com.apipokemon.apipokemon.dtos.TypeDto;
import com.apipokemon.apipokemon.model.Pokemon;
import lombok.AllArgsConstructor;
import org.json.*;
import org.apache.tomcat.util.json.ParseException;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;


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
                .path("api/v2/")
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
    public PokemonDto buscarPorIdOuNomeAposentado(String idOuNome) {
//        Pokemon pokemon = new Pokemon();
//        PokemonDto dto = template.getForObject("/pokemon/{idOuNome}", PokemonDto.class, idOuNome);
//        pokemon.setId(dto.getId());
//        pokemon.setName(dto.getName());
//
//        if (dto.getTypes().size() >= 0) {
//            String nomeTipo = dto.getTypes().get(0).getType().get("name");
//            TypeDto tipoId = template.getForObject("/type/{nomeTipo}", TypeDto.class, nomeTipo);
//            pokemon.setTipoUm(tipoId.getId());
//        }
//        if (dto.getTypes().size() >= 1) {
//            String urlTipo = dto.getTypes().get(1).getType().get("url");
//            pokemon.setTipoDois(Long.parseLong(urlTipo.substring(30).replace("/", "")));
//        }
//        System.out.println("Nome tipo -> " + pokemon);
//
//
        return null;
    }

    @Transactional
    public PokemonDto buscarPorIdOuNome(String idOuNome) {
        String jString = template.getForObject("/pokemon/{idOuNome}", String.class, idOuNome);
        Pokemon pokemon = new Pokemon();

        JSONObject jObj = new JSONObject(jString);
        JSONArray novo = jObj.getJSONArray("types");

        pokemon.setId(Long.parseLong(jObj.get("id").toString()));
        pokemon.setName(jObj.get("name").toString());

        System.out.println("AQUI jObj ------------------------------------\n"+jObj.get("id"));
        System.out.println("AQUI Pokemon------------------------------------\n"+pokemon);


        return new PokemonDto();
    }

}

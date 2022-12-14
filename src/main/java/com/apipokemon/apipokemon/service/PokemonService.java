package com.apipokemon.apipokemon.service;

import com.apipokemon.apipokemon.dtos.PokemonDto;
import com.apipokemon.apipokemon.model.Pokemon;
import com.apipokemon.apipokemon.model.Type;
import com.apipokemon.apipokemon.repository.PokemonRepository;
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
public class PokemonService {

    //Exemplo: https://pokeapi.co/api/v2/pokemon/35
    private final UriComponents uri = UriComponentsBuilder.newInstance()
            .scheme("https")
            .host("pokeapi.co/")
            .path("api/v2/")
            //.queryParam("idOuNome","all")
            .build();

    private final RestTemplate template = new RestTemplateBuilder()
            .rootUri(uri.toUriString())
            .build();

    private final PokemonRepository pokemonRepository;

    private final TypeRepository typeRepository;


    @Transactional
    public List<Pokemon> saveAllPokemon() {
        String jString = template.getForObject("/pokemon/", String.class);
        JSONObject jObj = new JSONObject(jString);
        jString = template.getForObject("/pokemon/" + "?limit=" + jObj.get("count"), String.class);
        jObj = new JSONObject(jString);
        JSONArray jArrPokemon = jObj.getJSONArray("results");

        List<Type> tipos = typeRepository.findAll();

        pegandoPokemons:
        for (int i = 0; i < jArrPokemon.length(); i++) {
            JSONObject elementoArr = jArrPokemon.getJSONObject(i);
            Pokemon pokemon = new Pokemon();
            pokemon.setTypes(new ArrayList<>());

            pokemon.setName(elementoArr.getString("name"));
            String idString = elementoArr.getString("url")
                    .substring(33).replace("/", "");
            pokemon.setId(Long.parseLong(idString));
            pokemonRepository.save(pokemon);
        }
        typePokemonLinks();
        return pokemonRepository.findAll();
    }

    @Transactional
    public List<Pokemon> typePokemonLinks() {

        try {
            typeRepository.deletarTodosVinculosComPokemons();
        } catch (Exception e) {
        }
        List<Pokemon> pokemons = pokemonRepository.findAll();
        List<Type> tipos = typeRepository.findAll();
        pegandoPokemons:
        for (Pokemon pokemon : pokemons) {
            //Adicionando tipo(s)
            String jPokeS = template.getForObject("/pokemon/" + pokemon.getId(), String.class);
            JSONObject jPokeObj = new JSONObject(jPokeS);
            JSONArray jArrTypes = jPokeObj.getJSONArray("types");
            pegandoTiposDosPokemons:
            for (int j = 0; j < jArrTypes.length(); j++) {
                JSONObject typesElement = jArrTypes.getJSONObject(j);
                JSONObject gettingTypeName = typesElement.getJSONObject("type");
                String sTipo = gettingTypeName.getString("name");
                forListaTipos:
                for (Type elemento : tipos) {
                    if (elemento.getName().contains(sTipo)) {
                        pokemon.getTypes().add(elemento);
                        if (jArrTypes.length() == 2 && j == 1) {
                            typeRepository.addRelacionarPokemonTipo(pokemon.getId(),
                                    pokemon.getTypes().get(0).getId(), "p");
                            typeRepository.addRelacionarPokemonTipo(pokemon.getId(),
                                    pokemon.getTypes().get(1).getId(), "s");
                        } else if (jArrTypes.length() == 1) {
                            typeRepository.addRelacionarPokemonTipo(pokemon.getId(),
                                    pokemon.getTypes().get(0).getId(), "p");
                        } else {
                            continue forListaTipos;
                        }
                        break forListaTipos;
                    }
                }
            }
            pokemonRepository.save(pokemon);
        }
        return new ArrayList<Pokemon>();
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

        System.out.println("AQUI jObj ------------------------------------\n" + jObj.get("id"));
        System.out.println("AQUI Pokemon------------------------------------\n" + pokemon);


        return new PokemonDto();
    }

}

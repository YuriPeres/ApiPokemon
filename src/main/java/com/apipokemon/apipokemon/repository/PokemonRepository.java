package com.apipokemon.apipokemon.repository;

import com.apipokemon.apipokemon.model.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PokemonRepository extends JpaRepository<Pokemon, Long> {


}

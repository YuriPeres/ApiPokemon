package com.apipokemon.apipokemon.repository;

import com.apipokemon.apipokemon.model.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TypeRepository extends JpaRepository<Type, Long> {

    Type findByName(String name);

    @Modifying
    @Query(value = "insert into tb_pokemon_tipo (id_pokemon, id_tipo, flag_slot) " +
                   "values (:idPokemon, :idTipo, :flagSlot)", nativeQuery = true)
    void relacionarPokemonTipo(@Param("idPokemon") Long idPokemon, @Param("idTipo") Long idTipo,
                               @Param("flagSlot") String flagSlot);
}

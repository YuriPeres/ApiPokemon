package com.apipokemon.apipokemon.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "tb_tipo_vantagem")
public class TypeRelations {

    @Id
    private Long id;

    @Column(name = "id_tipo")
    private Long idTipo;

    @Column(name = "relacao")
    private String relacao;

    @Column(name = "id_tipo_relacionado")
    private String idTipoRelacionado;

}

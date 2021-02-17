package com.mitocode.repo;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mitocode.model.ConsultaExamen;

/**
 * JpaRepository<Clase, PrimaryKey>
 * 
 * Clase: Clase que va a trabajar la Entity PrimaryKey: Llave primaria de la
 * entidad
 */

public interface IConsultaExamenRepo extends IGenericRepo<ConsultaExamen, Integer> {

	@Modifying
	@Query(value = "INSERT INTO consulta_examen(id_consulta, id_examen) VALUES (:idConsulta, :idExamen)", nativeQuery = true)
	Integer registrar(@Param("idConsulta") Integer idConsulta, @Param("idExamen") Integer idExamen);

}

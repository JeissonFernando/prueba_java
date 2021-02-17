package com.mitocode.repo;

import com.mitocode.model.Consulta;

/**
 * JpaRepository<Clase, PrimaryKey>
 * 
 * Clase: Clase que va a trabajar la Entity PrimaryKey: Llave primaria de la
 * entidad
 */

public interface IConsultaRepo extends IGenericRepo<Consulta, Integer> {

}

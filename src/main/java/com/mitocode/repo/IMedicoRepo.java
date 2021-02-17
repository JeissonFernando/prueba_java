package com.mitocode.repo;

import com.mitocode.model.Medico;

/**
 * JpaRepository<Clase, PrimaryKey>
 * 
 * Clase: Clase que va a trabajar la Entity PrimaryKey: Llave primaria de la
 * entidad
 */

public interface IMedicoRepo extends IGenericRepo<Medico, Integer> {

}

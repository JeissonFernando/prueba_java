package com.mitocode.repo;

import com.mitocode.model.Paciente;

/**
 * JpaRepository<Clase, PrimaryKey>
 * 
 * Clase: Clase que va a trabajar la Entity PrimaryKey: Llave primaria de la
 * entidad
 */

public interface IPacienteRepo extends IGenericRepo<Paciente, Integer> {

}

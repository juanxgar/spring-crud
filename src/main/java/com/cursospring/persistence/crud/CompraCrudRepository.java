package com.cursospring.persistence.crud;

import com.cursospring.persistence.entity.Compra;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

//Dnetro de los <> se pone la entidad y el tipo que tiene la clave primaria
public interface CompraCrudRepository extends CrudRepository<Compra, Integer> {

    Optional<List<Compra>> findByIdCliente(String idCliente);
}

package com.apirest.apirest.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apirest.apirest.Entities.Producto;
                                            //<Tipo de entidad, Tipo de identificador>
public interface ProductoRepository extends JpaRepository <Producto, Long>{

}

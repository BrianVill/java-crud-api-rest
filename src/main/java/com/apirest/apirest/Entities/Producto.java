package com.apirest.apirest.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity //con esto java sabe que esto va a ser de tipo entidad
public class Producto {

    @Id //el primer atributo de clase ya que sera el identificador unico de cada producto que hagamos
    @GeneratedValue(strategy = GenerationType.IDENTITY)//aca le damos la estrategia de creacion que necesitamos para el ID
    //atributos
    private long id;
    private String nombre;
    private double precio;

    //Getters y Setters
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    
    

}

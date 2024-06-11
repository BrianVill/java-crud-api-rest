//Aca es dode vamos a poner todas las direcciones para consumir con un cliente
package com.apirest.apirest.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apirest.apirest.Repositories.ProductoRepository;
import com.apirest.apirest.Entities.Producto;

@RestController
@RequestMapping("/productos") // con esto estamos habilitando que /productos pueda ser leida por un cliente
public class ProductoController {

    // AutoWired: con esto creamos una instancia en nuestro repositorio
    // automaticamente con Spring
    @Autowired
    private ProductoRepository productoRepository;

    // Metodos HTTP
    @GetMapping
    public List<Producto> obtenerProductos() {

        return productoRepository.findAll();
        // esto nos trae todos los productos que posee el repositorio
    }

    @GetMapping("/{id}") // para que reciba el id
    public Producto obtenerProductoPorId(@PathVariable long id) {
        return productoRepository.findById(id) // Devuelve el producto tal cual lo encontro
                .orElseThrow(() -> new RuntimeException("No se encontro el producto con el ID: " + id));
    }

    @PostMapping
    public Producto crearProducto(@RequestBody Producto producto) {

        return productoRepository.save(producto);
        // Con esto estamos grabando en la base de datos y tambien devuelve un producto
    }

    @PutMapping("/{id}")
    public Producto actualizarProducto(@PathVariable long id, @RequestBody Producto detallesProducto) {
        Producto producto = productoRepository.findById(id)// asignamos el producto a una variable llamada producto
                .orElseThrow(() -> new RuntimeException("No se encontro el producto con el ID: " + id));
        producto.setNombre(detallesProducto.getNombre());// modificamos el nombre
        producto.setPrecio(detallesProducto.getPrecio());// modificamos el precio

        return productoRepository.save(producto);// guarda y actualiza todo en la base de datos

    }

    @DeleteMapping("/{id}")
    public String borrarProducto(@PathVariable long id) {
        Producto producto = productoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontro el producto con el ID: " + id));

        productoRepository.save(producto);

        return "El producto con el ID: " + id + " fue eliminado correctamente";
    }

}

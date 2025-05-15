package com.example.SpringApp008D.Controller;

import com.example.SpringApp008D.Model.Producto;
import com.example.SpringApp008D.Service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/inventario")
public class InventarioController {

    @Autowired
    private ProductoService productoService;

    @GetMapping
    public String getAllProducts() {
        return productoService.getAllProducto();
    }

    @GetMapping("/{id}")
    public String getProductById(@PathVariable int id) {
        return productoService.getProductoById(id);
    }

    @PostMapping
    public String addProduct(@RequestBody Producto producto) {
        return productoService.addProduct(producto);
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable int id) {
        return productoService.deleteProducto(id);
    }
    @PutMapping("/{id}")
    public String updateProduct(@PathVariable int id, @RequestBody Producto producto) {
        return productoService.updateProducto(id, producto);
    }
}

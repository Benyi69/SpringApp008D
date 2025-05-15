package com.example.SpringApp008D.Service;

import com.example.SpringApp008D.Model.Producto;
import com.example.SpringApp008D.Repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    public String getAllProducto() {
        String output="";
        for (Producto producto : productoRepository.findAll()) {
            output+="ID Producto: "+ producto.getId_producto()+"\n";
            output+="Nombre: "+ producto.getNombre()+"\n";
            output+="Marca: "+ producto.getMarca()+"\n";
            output+="Precio: "+ producto.getPrecio()+"\n";
            output+="ID familia "+ producto.getId_familia()+"\n";
        }
        if(output.isEmpty()){
            return "Producto no encontrado";
        }else{
            return output;
        }
    }
    public String getProductoById(int id) {
        String output="";
        if(productoRepository.existsById(id)){
            Producto producto = productoRepository.findById(id).get();
            output+="ID Producto: "+ producto.getId_producto()+"\n";
            output+="Nombre: "+producto.getNombre()+"\n";
            output+="Marca: "+producto.getMarca()+"\n";
            output+="Precio: "+producto.getPrecio()+"\n";
            output+="ID Familia: "+producto.getId_familia()+"\n";
            return output;
        }else{
            return "Producto no encontrado";
        }
    }
    public String addProduct(Producto producto) {
        productoRepository.save(producto);
        return "Producto agregado";
    }

    public String deleteProducto(int id) {
        if(productoRepository.existsById(id)){
            productoRepository.deleteById(id);
            return "Producto eliminado";
        }else{
            return "Producto no encontrado";
        }
    }

    public String updateProducto(int id,Producto producto) {
        if(productoRepository.existsById(id)){
            Producto buscado = productoRepository.findById(id).get();
            buscado.setId_producto(producto.getId_producto());
            buscado.setNombre(producto.getNombre());
            buscado.setMarca(producto.getMarca());
            buscado.setPrecio(producto.getPrecio());
            productoRepository.save(buscado);
            return "Producto editado";
        }else{
            return "Producto no encontrado";
        }
    }
}

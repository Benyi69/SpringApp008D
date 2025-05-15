package com.example.SpringApp008D.Service;

import com.example.SpringApp008D.Model.Inventario;
import com.example.SpringApp008D.Repository.InventarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InventarioService {

    @Autowired
    private InventarioRepository inventarioRepository;

    public String addInventario(Inventario inventario) {
        inventarioRepository.save(inventario);
        return "Inventario agregado correctamente.";
    }

    public String updateInventario(int id, Inventario nuevoInventario) {
        Optional<Inventario> inventarioExistente = inventarioRepository.findById(id);
        if (inventarioExistente.isPresent()) {
            Inventario inv = inventarioExistente.get();
            inv.setNombre(nuevoInventario.getNombre());
            inv.setStock(nuevoInventario.getStock());
            inv.setStockMinimo(nuevoInventario.getStockMinimo());
            inventarioRepository.save(inv);
            return "Inventario actualizado correctamente.";
        } else {
            return "Inventario no encontrado.";
        }
    }

    public String deleteInventario(int id) {
        if (inventarioRepository.existsById(id)) {
            inventarioRepository.deleteById(id);
            return "Inventario eliminado.";
        }
        return "Inventario no encontrado.";
    }

    public Inventario getInventario(int id) {
        return inventarioRepository.findById(id).orElse(null);
    }

    public List<Inventario> getAllInventarios() {
        return inventarioRepository.findAll();
    }

    public String sumarStock(int id, int cantidad) {
        Optional<Inventario> invOpt = inventarioRepository.findById(id);
        if (invOpt.isPresent()) {
            Inventario inv = invOpt.get();
            inv.setStock(inv.getStock() + cantidad);
            inventarioRepository.save(inv);
            return "Stock incrementado.";
        } else {
            return "Inventario no encontrado.";
        }
    }

    public String restarStock(int id, int cantidad) {
        Optional<Inventario> invOpt = inventarioRepository.findById(id);
        if (invOpt.isPresent()) {
            Inventario inv = invOpt.get();
            if (inv.getStock() >= cantidad) {
                inv.setStock(inv.getStock() - cantidad);
                inventarioRepository.save(inv);
                return "Stock decrementado.";
            } else {
                return "Stock insuficiente.";
            }
        } else {
            return "Inventario no encontrado.";
        }
    }
}

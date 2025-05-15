package com.example.SpringApp008D.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "INVENTARIO")
public class Inventario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PRODUCTO")
    private int idProducto;

    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "STOCK")
    private int stock;

    @Column(name = "STOCK_MINIMO")
    private int stockMinimo;
}


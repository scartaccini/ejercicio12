package com.example.Ejercicio7.entidad;

import javax.persistence.*;


@Entity
public class Laptop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String marca;
    private String model;
    private boolean stock;


    public Laptop() {
    }

    public Laptop(Long id, String marca, String model, boolean stock ) {
        this.id = id;
        this.marca = marca;
        this.model = model;
        this.stock = stock;

    }

    public Long getId() {
        return id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public boolean isStock() {
        return stock;
    }

    public void setStock(boolean stock) {
        this.stock = stock;
    }
}
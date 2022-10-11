package com.example.Ejercicio7.repositorio;

import com.example.Ejercicio7.entidad.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaptopRepository extends JpaRepository<Laptop, Long> {
}
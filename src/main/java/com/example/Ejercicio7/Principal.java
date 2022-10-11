package com.example.Ejercicio7;

import com.example.Ejercicio7.entidad.Laptop;
import com.example.Ejercicio7.repositorio.LaptopRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Principal {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Principal.class, args);
		LaptopRepository repository = context.getBean(LaptopRepository.class);

	}

}
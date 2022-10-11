package com.example.Ejercicio7.controlador;

import com.example.Ejercicio7.entidad.Laptop;
import com.example.Ejercicio7.repositorio.LaptopRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
public class LaptopController {
@Value("${app.message}")
String message;
private LaptopRepository laptopRepository;

public LaptopController(LaptopRepository laptopRepository) {

this.laptopRepository = laptopRepository;
}

@GetMapping("/probando")
public String prueba(){
    System.out.println(message);
    return message;
}


@GetMapping("/api/listar/laptops")
public List<Laptop> findAll(){

return laptopRepository.findAll();

}

@GetMapping("/api/listar/laptop/{id}")
public ResponseEntity<Laptop> findOneById(@PathVariable Long id){

Optional<Laptop> bookOpt = laptopRepository.findById(id);

if(bookOpt.isPresent())
    return ResponseEntity.ok(bookOpt.get());
else
    return ResponseEntity.notFound().build();

}


@PutMapping("/api/actualizar/laptop")
public ResponseEntity<Laptop> update(@RequestBody Laptop laptop){
    if(laptop.getId() == null ) {
        return ResponseEntity.badRequest().build();
    }
    if(!laptopRepository.existsById(laptop.getId())){

        return ResponseEntity.notFound().build();
    }

    Laptop result = laptopRepository.save(laptop);
    return ResponseEntity.ok(result);
}

@PostMapping("/api/crear/laptop")
public ResponseEntity<Laptop> create(@RequestBody Laptop laptop){

    if(laptop.getId() != null) {

        return ResponseEntity.badRequest().build();
    }
    Laptop result = laptopRepository.save(laptop);
    return ResponseEntity.ok(result);
}

@DeleteMapping("/api/eliminar/laptops")
public ResponseEntity<Laptop> deleteAll(){

    laptopRepository.deleteAll();
    return ResponseEntity.noContent().build();
}

@DeleteMapping("/api/eliminar/laptop/{id}")
public ResponseEntity<Laptop> delete(@PathVariable Long id){

    if(!laptopRepository.existsById(id)){

        return ResponseEntity.notFound().build();
    }

    laptopRepository.deleteById(id);

    return ResponseEntity.noContent().build();
}

}


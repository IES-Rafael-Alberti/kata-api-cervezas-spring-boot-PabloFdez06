package com.example.cervezas.controller;

import com.example.cervezas.entity.Beer;
import com.example.cervezas.repository.BeerRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/beers")
@Tag(name = "Beers", description = "API para gestionar cervezas")
public class BeerController {

    @Autowired
    private BeerRepository beerRepository;

    @GetMapping
    @Operation(summary = "Obtener todas las cervezas")
    public ResponseEntity<List<Beer>> getAllBeers() {
        List<Beer> beers = beerRepository.findAll();
        return ResponseEntity.ok(beers);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener cerveza por ID")
    public ResponseEntity<Beer> getBeerById(@PathVariable Integer id) {
        Optional<Beer> beer = beerRepository.findById(id);
        if (beer.isPresent()) {
            return ResponseEntity.ok(beer.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @Operation(summary = "Crear una nueva cerveza")
    public ResponseEntity<Beer> createBeer(@RequestBody Beer beer) {
        Beer savedBeer = beerRepository.save(beer);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedBeer);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar una cerveza existente")
    public ResponseEntity<Beer> updateBeer(@PathVariable Integer id, @RequestBody Beer beerDetails) {
        Optional<Beer> beer = beerRepository.findById(id);
        if (beer.isPresent()) {
            Beer beerToUpdate = beer.get();
            beerToUpdate.setName(beerDetails.getName());
            beerToUpdate.setCategoryId(beerDetails.getCategoryId());
            beerToUpdate.setStyleId(beerDetails.getStyleId());
            beerToUpdate.setAbv(beerDetails.getAbv());
            beerToUpdate.setIbu(beerDetails.getIbu());
            beerToUpdate.setGlasswareId(beerDetails.getGlasswareId());
            beerToUpdate.setOg(beerDetails.getOg());
            beerToUpdate.setDescription(beerDetails.getDescription());
            beerToUpdate.setLastMod(beerDetails.getLastMod());
            Beer updatedBeer = beerRepository.save(beerToUpdate);
            return ResponseEntity.ok(updatedBeer);
        }
        return ResponseEntity.notFound().build();
    }

    @PatchMapping("/{id}")
    @Operation(summary = "Actualizar parcialmente una cerveza")
    public ResponseEntity<Beer> partialUpdateBeer(@PathVariable Integer id, @RequestBody Beer beerDetails) {
        Optional<Beer> beer = beerRepository.findById(id);
        if (beer.isPresent()) {
            Beer beerToUpdate = beer.get();
            if (beerDetails.getName() != null) {
                beerToUpdate.setName(beerDetails.getName());
            }
            if (beerDetails.getCategoryId() != null) {
                beerToUpdate.setCategoryId(beerDetails.getCategoryId());
            }
            if (beerDetails.getStyleId() != null) {
                beerToUpdate.setStyleId(beerDetails.getStyleId());
            }
            if (beerDetails.getAbv() != null) {
                beerToUpdate.setAbv(beerDetails.getAbv());
            }
            if (beerDetails.getIbu() != null) {
                beerToUpdate.setIbu(beerDetails.getIbu());
            }
            if (beerDetails.getGlasswareId() != null) {
                beerToUpdate.setGlasswareId(beerDetails.getGlasswareId());
            }
            if (beerDetails.getOg() != null) {
                beerToUpdate.setOg(beerDetails.getOg());
            }
            if (beerDetails.getDescription() != null) {
                beerToUpdate.setDescription(beerDetails.getDescription());
            }
            Beer updatedBeer = beerRepository.save(beerToUpdate);
            return ResponseEntity.ok(updatedBeer);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar una cerveza")
    public ResponseEntity<Void> deleteBeer(@PathVariable Integer id) {
        if (beerRepository.existsById(id)) {
            beerRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

}


package com.example.cervezas.controller;

import com.example.cervezas.entity.Brewerie;
import com.example.cervezas.repository.BrewerieRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/breweries")
@Tag(name = "Breweries", description = "API para gestionar cervecerías")
public class BrewerieController {

    @Autowired
    private BrewerieRepository brewerieRepository;

    @GetMapping
    @Operation(summary = "Obtener todas las cervecerías")
    public ResponseEntity<List<Brewerie>> getAllBreweries() {
        List<Brewerie> breweries = brewerieRepository.findAll();
        return ResponseEntity.ok(breweries);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener cervecería por ID")
    public ResponseEntity<Brewerie> getBrewerieById(@PathVariable Integer id) {
        Optional<Brewerie> brewerie = brewerieRepository.findById(id);
        if (brewerie.isPresent()) {
            return ResponseEntity.ok(brewerie.get());
        }
        return ResponseEntity.notFound().build();
    }

}


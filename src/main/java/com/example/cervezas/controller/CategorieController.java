package com.example.cervezas.controller;

import com.example.cervezas.entity.Categorie;
import com.example.cervezas.repository.CategorieRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categories")
@Tag(name = "Categories", description = "API para gestionar categorías")
public class CategorieController {

    @Autowired
    private CategorieRepository categorieRepository;

    @GetMapping
    @Operation(summary = "Obtener todas las categorías")
    public ResponseEntity<List<Categorie>> getAllCategories() {
        List<Categorie> categories = categorieRepository.findAll();
        return ResponseEntity.ok(categories);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener categoría por ID")
    public ResponseEntity<Categorie> getCategorieById(@PathVariable Integer id) {
        Optional<Categorie> categorie = categorieRepository.findById(id);
        if (categorie.isPresent()) {
            return ResponseEntity.ok(categorie.get());
        }
        return ResponseEntity.notFound().build();
    }

}


package com.example.cervezas.controller;

import com.example.cervezas.entity.Style;
import com.example.cervezas.repository.StyleRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/styles")
@Tag(name = "Styles", description = "API para gestionar estilos de cerveza")
public class StyleController {

    @Autowired
    private StyleRepository styleRepository;

    @GetMapping
    @Operation(summary = "Obtener todos los estilos")
    public ResponseEntity<List<Style>> getAllStyles() {
        List<Style> styles = styleRepository.findAll();
        return ResponseEntity.ok(styles);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener estilo por ID")
    public ResponseEntity<Style> getStyleById(@PathVariable Integer id) {
        Optional<Style> style = styleRepository.findById(id);
        if (style.isPresent()) {
            return ResponseEntity.ok(style.get());
        }
        return ResponseEntity.notFound().build();
    }

}


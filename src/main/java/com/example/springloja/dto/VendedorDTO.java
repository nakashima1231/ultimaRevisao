package com.example.springloja.dto;

import com.example.springloja.entities.Vendedor;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

public record VendedorDTO(
         Long id,
         String nome,
         String foto
) {
    public VendedorDTO(Vendedor v) {
        this(v.getId(), v.getNome(), v.getFoto());
    }
}

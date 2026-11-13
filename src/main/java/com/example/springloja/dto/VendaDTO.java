package com.example.springloja.dto;

import com.example.springloja.entities.Venda;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

public record VendaDTO(
         Long id,
         @DateTimeFormat(iso=DateTimeFormat.ISO.DATE)
         LocalDateTime data,
         Double valor,
         ClienteDTO cliente,
         VendedorDTO vendedor
) {
    public VendaDTO(Venda v) {
        this(v.getId(), v.getData(), v.getValor(), new ClienteDTO(v.getCliente()), new VendedorDTO(v.getVendedor()));
    }
}

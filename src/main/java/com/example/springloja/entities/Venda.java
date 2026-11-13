package com.example.springloja.entities;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Entity
public class Venda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "id da venda", example = "1")
    private Long id;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Schema(description = "data da venda", example = "01/01/2026")
    private LocalDateTime data;

    @Min(value = 0, message = "valor nao pode ser negativo")
    @NotNull(message = "Valor nao pode ser nulo")
    @Schema(description = "valor da venda", example = "123.50")
    private Double valor;

    @NotNull(message = "cliente nao pode estar vazio")
    @ManyToOne
    private Cliente cliente;

    @NotNull(message = "vendedor nao pode estar vazio")
    @ManyToOne
    private Vendedor vendedor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }
}

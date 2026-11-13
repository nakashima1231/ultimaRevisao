package com.example.springloja.controller;

import com.example.springloja.dto.VendaDTO;
import com.example.springloja.entities.Venda;
import com.example.springloja.services.VendaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/vendas")
@CrossOrigin
@Tag(name="Vendas", description = "Gerenciamento de vendas")
public class VendaController {
    @Autowired
    private VendaService service;


    @GetMapping
    @Operation(summary = "Lista todos as vendas", description = "Retorna uma lista completa de vendas")
    public List<VendaDTO> listar() {
        return service.listarTodos();
    }

    @PostMapping()
    @SecurityRequirement(name = "bearerAuth")
    public String criar(@Valid @RequestPart("venda") Venda venda) {
        service.salvar(venda);
        return "Venda " + venda.getId() + " criado com sucesso!";
    }

    @PutMapping(value = "/{id}")
    @SecurityRequirement(name = "bearerAuth")
    public String atualizar(
            @PathVariable Long id,
            @Valid @RequestPart("vendedor") Venda venda) {

        service.atualizar(id, venda);
        return "Venda atualizado com sucesso!";
    }

    @DeleteMapping("/{id}")
    public String deletar(@PathVariable Long id){
        service.excluir(id);
        return "Venda deletado com sucesso!";
    }
}

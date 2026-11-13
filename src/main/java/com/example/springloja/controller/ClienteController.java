package com.example.springloja.controller;


import com.example.springloja.dto.ClienteDTO;
import com.example.springloja.entities.Cliente;
import com.example.springloja.services.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
@CrossOrigin
public class ClienteController {
    @Autowired
    ClienteService service;

    //get
    @GetMapping
    public List<ClienteDTO> listar() {
        return service.listarTodos();
    }

    @PostMapping
    public String salvar(@Valid @RequestBody Cliente cliente) {
        service.salvar(cliente);
        return "Usuario salvo com sucesso!";
    }

    @PutMapping("/{id}")
    public String atualizar(@PathVariable Long id,@Valid @RequestBody Cliente cliente){
        cliente.setId(id);
        service.atualizar(id, cliente);
        return "Usuario atualizado com sucesso!";
    }

    @DeleteMapping("/{id}")
    public String deletar(@PathVariable Long id){
        service.excluir(id);
        return "Usuario deletado com sucesso!";
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDTO> buscarPorId(@PathVariable Long id){
        ClienteDTO obj = service.buscarPorId(id);

        if (obj != null){
            return ResponseEntity.ok().body(obj);
        } else{
            return ResponseEntity.notFound().build();
        }
    }


}

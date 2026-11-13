package com.example.springloja.services;

import com.example.springloja.dto.ClienteDTO;
import com.example.springloja.dto.ProdutoDTO;
import com.example.springloja.entities.Cliente;
import com.example.springloja.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    public List<ClienteDTO> listarTodos() {
        return repository.findAll().stream().map(ClienteDTO:: new).toList();
    }

    public void salvar(Cliente cliente) {
        repository.save(cliente);
    }

    @Transactional
    public Cliente atualizar(Long id, Cliente dadosAtualizados) {
        Cliente clienteExistente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado com id: " + id));

        // Atualiza os campos normais
        clienteExistente.setNome(dadosAtualizados.getNome());
        clienteExistente.setRenda(dadosAtualizados.getRenda());

        return repository.save(clienteExistente);
    }

    public void excluir(Long id){
        repository.deleteById(id);
    }

    public List<ClienteDTO> buscarPorNome(String nome) {
        return repository.findByNomeContainingIgnoreCase(nome).stream().map(ClienteDTO::new).toList();
    }

    public List<ClienteDTO> buscarPorRendaoMaximo(Double renda) {
        return repository.findByRendaLessThanEqual(renda).stream().map(ClienteDTO::new).toList();
    }

    public ClienteDTO buscarPorId(Long id){
        return repository.findById(id).stream().map(ClienteDTO::new).findFirst().orElse(null);
    }
}

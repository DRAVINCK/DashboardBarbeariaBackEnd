package com.dravinck.dashboardbarbearia.service;

import com.dravinck.dashboardbarbearia.entity.Cliente;
import com.dravinck.dashboardbarbearia.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository Repository;

    public List<Cliente> findAll(){
        return Repository.findAll();
    }

    public Cliente save(Cliente cliente){
        return Repository.save(cliente);
    }

    public Optional<Cliente> findById(Long id){
        return Repository.findById(id);
    }

    public List<Cliente> findByNome(String nome){
        return Repository.findByNome(nome);
    }

    public void delete (Long id){
        Repository.deleteById(id);
    }

    public Optional<Cliente>update(Long id, Cliente updateCliente){
        Optional<Cliente> optCliente = Repository.findById(id);
        if (optCliente.isPresent()){
            Cliente clienteFound = optCliente.get();
            clienteFound.setNome(updateCliente.getNome());
            clienteFound.setTelefone(updateCliente.getTelefone());
            return Optional.of(Repository.save(clienteFound));
        }
        return Optional.empty();
    }
}

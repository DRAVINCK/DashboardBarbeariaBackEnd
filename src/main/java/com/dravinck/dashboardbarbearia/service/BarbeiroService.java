package com.dravinck.dashboardbarbearia.service;

import com.dravinck.dashboardbarbearia.entity.Barbeiro;
import com.dravinck.dashboardbarbearia.repository.BarbeiroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BarbeiroService {

    private final BarbeiroRepository Repository;

    public List<Barbeiro> findAll(){
        return Repository.findAll();
    }

    public Barbeiro save(Barbeiro barbeiro){
        return Repository.save(barbeiro);
    }

    public Optional<Barbeiro> findById(Long id){
        return Repository.findById(id);
    }

    public void update(Long id, Barbeiro updateBarbeiro){
        Optional<Barbeiro> optBarbeiro = Repository.findById(id);
        if (optBarbeiro.isPresent()){
            Barbeiro barbeiroFound = optBarbeiro.get();
            barbeiroFound.setNome(updateBarbeiro.getNome());
            Repository.save(barbeiroFound);
        }
    }
    public void delete (Long id){
        Repository.deleteById(id);
    }

}

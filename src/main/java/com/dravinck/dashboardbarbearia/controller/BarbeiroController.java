package com.dravinck.dashboardbarbearia.controller;

import com.dravinck.dashboardbarbearia.controller.request.BarbeiroRequest;
import com.dravinck.dashboardbarbearia.controller.response.BarbeiroResponse;
import com.dravinck.dashboardbarbearia.entity.Barbeiro;
import com.dravinck.dashboardbarbearia.mapper.BarbeiroMapper;
import com.dravinck.dashboardbarbearia.service.BarbeiroService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("barber/barbeiro")
@RequiredArgsConstructor
public class BarbeiroController {

    private final BarbeiroService service;

    @PostMapping
    public ResponseEntity<BarbeiroResponse> save(@Valid @RequestBody BarbeiroRequest barbeiro){
        Barbeiro save = service.save(BarbeiroMapper.toBabeiro(barbeiro));
        return ResponseEntity.ok(BarbeiroMapper.toBabeiroResponse(save));
    }

    @GetMapping
    public ResponseEntity<List<BarbeiroResponse>> findAllBarbeiro(){
        return ResponseEntity.ok(service.findAll()
                .stream()
                .map(BarbeiroMapper::toBabeiroResponse)
                .toList());
    }

    @PutMapping("{id}")
    public ResponseEntity<BarbeiroResponse> update(@PathVariable Long id, @Valid @RequestBody BarbeiroRequest barbeiro){
        service.update(id, BarbeiroMapper.toBabeiro(barbeiro));
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}

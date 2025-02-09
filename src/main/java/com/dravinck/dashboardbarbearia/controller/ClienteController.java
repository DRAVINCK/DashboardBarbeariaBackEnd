package com.dravinck.dashboardbarbearia.controller;

import com.dravinck.dashboardbarbearia.controller.request.ClienteRequest;
import com.dravinck.dashboardbarbearia.controller.response.ClienteResponse;
import com.dravinck.dashboardbarbearia.entity.Cliente;
import com.dravinck.dashboardbarbearia.mapper.ClienteMapper;
import com.dravinck.dashboardbarbearia.service.ClienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("barber/cliente")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService clienteService;


    @Operation(summary = "Cadastrar um filme",description = "Cadastra um filme no banco de dados",
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "201", description = "Filme cadastrado com sucesso",
            content = @Content(schema = @Schema(implementation = ClienteResponse.class)))
    @PostMapping
    public ResponseEntity<ClienteResponse> save(@Valid @RequestBody ClienteRequest cliente) {
        Cliente save = clienteService.save(ClienteMapper.toCliente(cliente));
        return ResponseEntity.ok(ClienteMapper.toClienteResponse(save));
    }

    @GetMapping
    public ResponseEntity<List<ClienteResponse>> findAllCliente() {
        return ResponseEntity.ok(clienteService.findAll()
                .stream()
                .map(ClienteMapper::toClienteResponse)
                .toList());
    }

    @GetMapping("{id}")
    public ResponseEntity<ClienteResponse> findById(@PathVariable Long id) {
        return clienteService.findById(id)
                .map(cliente -> ResponseEntity.ok(ClienteMapper.toClienteResponse(cliente)))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/searchname")
    public ResponseEntity<List<ClienteResponse>> findByNome(@RequestParam String nome) {
        return ResponseEntity.ok(clienteService.findByNome(nome)
                .stream()
                .map(ClienteMapper::toClienteResponse)
                .toList());
    }

    @PutMapping("{id}")
    public ResponseEntity<ClienteResponse> update(@PathVariable Long id, @Valid @RequestBody ClienteRequest request) {
        return clienteService.update(id, ClienteMapper.toCliente(request))
                .map(cliente -> ResponseEntity.ok(ClienteMapper.toClienteResponse(cliente)))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteByClienteId(@PathVariable Long id) {
        Optional<Cliente> clienteOptional = clienteService.findById(id);
        if (clienteOptional.isPresent()) {
            clienteService.delete(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
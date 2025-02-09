package com.dravinck.dashboardbarbearia.mapper;

import com.dravinck.dashboardbarbearia.controller.request.ClienteRequest;
import com.dravinck.dashboardbarbearia.controller.response.ClienteResponse;
import com.dravinck.dashboardbarbearia.entity.Cliente;
import lombok.experimental.UtilityClass;

import java.util.List;

@UtilityClass
public class ClienteMapper {

    public static Cliente toCliente(ClienteRequest request){

        return Cliente.builder()
                .nome(request.nome())
                .telefone(request.telefone())
                .build();
    }

    public static ClienteResponse toClienteResponse(Cliente cliente){

        return ClienteResponse.builder()
                .id(cliente.getId())
                .nome(cliente.getNome())
                .telefone(cliente.getTelefone())
                .build();
    }

}

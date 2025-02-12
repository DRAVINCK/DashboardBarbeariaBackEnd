package com.dravinck.dashboardbarbearia.mapper;

import com.dravinck.dashboardbarbearia.controller.request.BarbeiroRequest;
import com.dravinck.dashboardbarbearia.controller.response.BarbeiroResponse;
import com.dravinck.dashboardbarbearia.entity.Barbeiro;

public class BarbeiroMapper {

    public static Barbeiro toBabeiro(BarbeiroRequest barbeiroRequest) {
        return Barbeiro.builder()
                .nome(barbeiroRequest.nome())
                .build();
    }

    public static BarbeiroResponse toBabeiroResponse(Barbeiro barbeiro) {

        return BarbeiroResponse.builder()
                .id(barbeiro.getId())
                .nome(barbeiro.getNome())
                .build();
    }
}

package com.dravinck.dashboardbarbearia.controller.response;

import lombok.Builder;

@Builder
public record ClienteResponse (Long id,
                               String nome,
                               String telefone
) {

}

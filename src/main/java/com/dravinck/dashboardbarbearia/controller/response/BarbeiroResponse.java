package com.dravinck.dashboardbarbearia.controller.response;

import lombok.Builder;

@Builder
public record BarbeiroResponse (Long id,
                                String nome
) {
}

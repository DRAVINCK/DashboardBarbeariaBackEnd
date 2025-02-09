package com.dravinck.dashboardbarbearia.controller.request;

import jakarta.validation.constraints.NotEmpty;

public record ClienteRequest(@NotEmpty(message = "Nome não pode ser vazio")
                            String nome,
                            @NotEmpty(message = "Telefone não pode ser vazio")
                            String telefone
) {

}

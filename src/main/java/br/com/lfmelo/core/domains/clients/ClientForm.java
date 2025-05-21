package br.com.lfmelo.core.domains.clients;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientForm {

    @NotBlank(message = "Campo cpf é obrigatório")
    private String cpf;

    @NotBlank(message = "Campo name é obrigatório")
    private String name;

    @NotBlank(message = "Campo email é obrigatório")
    private String email;

    private String phone;
}

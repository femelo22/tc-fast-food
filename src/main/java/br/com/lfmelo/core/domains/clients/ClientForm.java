package br.com.lfmelo.core.domains.clients;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientForm {

    private String cpf;

    private String name;

    private String email;

    private String phone;
}

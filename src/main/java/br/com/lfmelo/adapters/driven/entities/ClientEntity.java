package br.com.lfmelo.adapters.driven.entities;

import br.com.lfmelo.core.domains.clients.Client;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "TBL_CLIENT")
@Table(name = "TBL_CLIENT")
public class ClientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cpf", length = 11)
    private String cpf;

    @Column(name = "name", length = 150)
    private String name;

    @Column(name = "email", length = 150)
    private String email;

    @Column(name = "phone", length = 30)
    private String phone;

    public ClientEntity(Client client) {
        this.id = client.getId();
        this.cpf = client.getCpf();
        this.email = client.getEmail();
        this.name = client.getName();
        this.phone = client.getPhone();
    }
}

package br.com.lfmelo.adapters.outbounds.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
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

    @Column(name = "password", length = 40)
    private String password;

    @Column(name = "phone", length = 30)
    private String phone;
}

package br.com.lfmelo.core.domains.clients;

public class Client {

    private Long id;

    private String cpf;

    private String name;

    private String email;

    private String phone;

    public Client() {

    }

    public Client(Long id, String cpf, String name, String email, String phone) {
        this.id = id;
        this.cpf = cpf;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public Client(String cpf) {
        this.cpf = cpf;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}

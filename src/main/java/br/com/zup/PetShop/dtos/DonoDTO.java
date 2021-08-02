package br.com.zup.PetShop.dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class DonoDTO {
    @Size(min = 2, message = "{validacao.nome}")
    private String nome;

    @Email(message = "{validacao.email}")
    @NotBlank(message = "{validacao.email.obrigatorio}")
    private String email;

    @Size(min = 10, max = 11, message = "{validacao.telefone}")
    private String telefone;

    public DonoDTO() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}

package br.com.zup.PetShop.dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class DonoDTO {
    @Size(min = 3, message = "Nome tem que ter pelo menos 3 letras")
    private String nome;

    @Email(message = "Formato de email invalido")
    @NotBlank(message = "Email é obrigatório")
    private String email;

    @Size(min = 10, max = 11, message = "Telefone tem que ser no minimo 10 numero ou no maximo 11")
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

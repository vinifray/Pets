package br.com.zup.PetShop.dtos;

import br.com.zup.PetShop.enuns.Especie;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class PetDTO {
    @Size(min = 2, message = "{validacao.nome}" )
    private String nome;
    @Min(value = 1, message = "{validacao.idade}")
    private int idade;

    @NotNull
    private Especie especie;

    @NotNull
    @Valid
    private DonoDTO dono;

    public PetDTO() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public Especie getEspecie() {
        return especie;
    }

    public void setEspecie(Especie especie) {
        this.especie = especie;
    }

    public DonoDTO getDono() {
        return dono;
    }

    public void setDono(DonoDTO dono) {
        this.dono = dono;
    }
}

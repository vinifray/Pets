package br.com.zup.PetShop.services;

import br.com.zup.PetShop.dtos.PetDTO;
import br.com.zup.PetShop.exceptions.PetNaoEncontradoException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PetService {

    private List<PetDTO> petshop = new ArrayList<>();

    public void adicionarPetNaLista(PetDTO petDTO){
        petshop.add(petDTO);
    }

    public List<PetDTO> retornarPetShop(){
        return this.petshop;
    }

    public PetDTO pesquisarPetPeloNome(String nome){
        PetDTO petDTO = null;
        for (PetDTO pet : petshop){
            if(pet.getNome().equals(nome)){
                petDTO = pet;
            }
        }

        if(petDTO != null){
            return petDTO;
        }

        throw new PetNaoEncontradoException("Pet não foi encontrado");
    }

}

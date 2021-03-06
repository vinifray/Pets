package br.com.zup.PetShop.services;

import br.com.zup.PetShop.dtos.PetDTO;
import br.com.zup.PetShop.exceptions.PetNaoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PetService {
    @Autowired
    private DonoService donoService;
    private List<PetDTO> petshop = new ArrayList<>();

    public void adicionarPetNaLista(PetDTO petDTO){
        donoService.adicionarDono(petDTO.getDono());
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

    private PetDTO atualizarPet(PetDTO objetoParaAtualizar, PetDTO objetoDaRequisao){
        objetoParaAtualizar.setDono(objetoDaRequisao.getDono());
        objetoParaAtualizar.setIdade(objetoDaRequisao.getIdade());
        objetoParaAtualizar.setEspecie(objetoDaRequisao.getEspecie());

        return objetoParaAtualizar;
    }

    public PetDTO atualizarOuAdicionarPet(PetDTO petDTO){
        try{
            PetDTO objetoDaLista = pesquisarPetPeloNome(petDTO.getNome());
            objetoDaLista = atualizarPet(objetoDaLista, petDTO);
            return objetoDaLista;

        }catch (PetNaoEncontradoException e){
            adicionarPetNaLista(petDTO);
            return petDTO;
        }
    }
}

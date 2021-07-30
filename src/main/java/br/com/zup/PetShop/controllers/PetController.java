package br.com.zup.PetShop.controllers;

import br.com.zup.PetShop.dtos.PetDTO;
import br.com.zup.PetShop.services.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/pets")
public class PetController {

    @Autowired
    private PetService petService;

    @PostMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void cadastrarPet(@RequestBody @Valid PetDTO petDTO){
        petService.adicionarPetNaLista(petDTO);
    }

    @GetMapping
    public List<PetDTO> visualizarPetShop(){
        return petService.retornarPetShop();
    }


}

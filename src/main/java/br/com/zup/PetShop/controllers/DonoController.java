package br.com.zup.PetShop.controllers;

import br.com.zup.PetShop.dtos.DonoDTO;
import br.com.zup.PetShop.services.DonoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/donos")
public class DonoController {

    @Autowired
    private DonoService donoService;

    @PostMapping
    public DonoDTO cadastrarDono(@RequestBody @Valid DonoDTO donoDTO){
        return donoService.adicionarDono(donoDTO);
    }
}

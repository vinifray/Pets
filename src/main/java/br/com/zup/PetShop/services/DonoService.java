package br.com.zup.PetShop.services;

import br.com.zup.PetShop.dtos.DonoDTO;
import br.com.zup.PetShop.exceptions.DonoDuplicadoException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DonoService {
    private List<DonoDTO> donos = new ArrayList<>();

    /**
    *Adicinar dono é um metodo que interage com a lista de donos na intenção de adicionar um dono novo
    *@return DonoDTO
    *@author Viny
     */
    public DonoDTO adicionarDono(DonoDTO dono){
        varificarSeExiste(dono);

        donos.add(dono);
        return dono;
    }

    public void varificarSeExiste(DonoDTO dono){
        for (DonoDTO obj : donos){
            if(obj.getNome().equals(dono.getNome())){
                throw new DonoDuplicadoException("Dono já cadastro");
            }
        }
    }

}

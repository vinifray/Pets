package br.com.zup.PetShop.exceptions;

public class PetNaoEncontradoException extends RuntimeException{

    public PetNaoEncontradoException(String message) {
        super(message);
    }
}

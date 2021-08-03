package br.com.zup.PetShop.exceptions;

public class DonoDuplicadoException extends RuntimeException {
    private int statusCode = 400;

    public DonoDuplicadoException(String message) {
        super(message);
    }
}

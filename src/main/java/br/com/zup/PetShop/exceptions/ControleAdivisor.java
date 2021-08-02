package br.com.zup.PetShop.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ControleAdivisor {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public MensagemDeErro manipularExcecoesDeValidacao(MethodArgumentNotValidException exception){
        List<FieldError> fildErros = exception.getBindingResult().getFieldErrors();
        /*
        Converte a lista de fildEerros para erros que é a classe customisada que criamos
        Para conversão usamos o Stream para manipular os objetos da lista e o lambida (->)
         */
        List<Erro> erros = fildErros.stream().map(objeto -> new Erro(objeto.getField(), objeto.getDefaultMessage()))
                .collect(Collectors.toList());

        return new MensagemDeErro(400, erros);
    }

    /*
    exemplo de exceção customizada.
     */
    @ExceptionHandler(PetNaoEncontradoException.class)
    public MensagemDeErro manipularPetNaoEncontrato(PetNaoEncontradoException exception){
        List<Erro> erros = Arrays.asList(new Erro(exception.getLocalizedMessage(), exception.getMessage()));

        return new MensagemDeErro(400, erros);
    }
}

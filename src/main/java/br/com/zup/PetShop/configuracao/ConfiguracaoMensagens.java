package br.com.zup.PetShop.configuracao;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Component;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@Component
public class ConfiguracaoMensagens {
    /*
    @bean serve para capturar o objeto do retorno do metodo e torna-lo gerenciavel pelo spring

    No metodo  messageResource() criamos um instancia de uma classe de configuração dizendo está localizado as mensagens de validação
    no metodo validator() criamos a instancia do Factory Valitador para ele reconhecer o objeto de messageSource

     */
    @Bean
    public MessageSource messageResource(){
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:MensagensDeValidacao");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

    @Bean
    public LocalValidatorFactoryBean validator(){
        LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
        bean.setValidationMessageSource(messageResource());
        return bean;
    }
}

package modelo.composicao;

import javax.persistence.Embeddable;

/*
A anotação Embeddable serve para informar que, apesar dessa classe não estar sendo
mapeada para dentro de um banco de dados, as informações nela devem ser persistidas
junto com outra classe que possua esta classe como variável.
*/
@Embeddable
public class Endereco {

    private String logradouro;
    private String complemento;

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
    
    
}

package modelo.basico;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*
Na utilização do hibernate, é necessários colocar de forma obrigatória duas anotações
@Entity é uma anotação que indica que esta classe é uma entidade no banco de dados.
    Ou seja, ela será ou já está mapeada no banco.
 */
@Entity
@Table(name = "produtos", schema = "curso_java")
public class Produto{

    /*
    No JPA, @Id indica que a variável abaixo da anotação será a chave primária no
    Banco de dados.
     */
    @Id
    /*
    No JPA, @GeneratedValue indica que os valores da variável abaixo da anotação
    serão atribuídos automaticamente.
    Já o '(strategy = GenerationType.IDENTITY)' auxilia com que, no momento que 
    a tabela for criada no BD, o ID do usuário será do tipo auto_increment.
     */
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /*
    Por padrão, o JPA define diversas características no banco de dados para variáveis.
    Por exemplo, por padrão, a variável 'nome' no banco de dados será um VARCHAR
    (porque ela é uma String), com 255 espaços, além de não ser obrigatório seu 
    preenchimento.
    Porém, com a anotação @Column, é possível alterar seu nome, ou se a variável aceita
    ou não atributos false, etc.
     */
    @Column(name = "nome", length = 120, nullable = false)
    private String nome;
    /*
    precision refere-se a quantas casas o número pode aceitar.
    scale refere-se a quantidade de casas decimais.
     */
    @Column(name = "preco", nullable = false, precision = 11, scale = 2)
    private Double preco;

    /*
    O cosntrutor padrão é essencial para que o JPA consiga realizar o mapeamento.
     */
    public Produto() {
    }

    public Produto(String nome, Double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

}

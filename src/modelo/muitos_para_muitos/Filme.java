package modelo.muitos_para_muitos;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "filmes")
public class Filme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Double nota;
    
    /*
    Utilizando a notação cascade = CascadeType.PERSIST no ManyToMany, ao adicionar
    um filme no método principal, caso haja algum ator vinculado ao objeto, esses 
    atores também serão persistidos automaticamente.
    Para acontecer o inverso (adicionar um ator e automaticamente adicionar um filme)
    é necessário colocar a anotação também em ator.
    */
    @ManyToMany (cascade = CascadeType.PERSIST)
    /*
    Em banco de dados, tabelas que possuem relação de muitos para muitos geram uma
    nova tabela que armazena o relacionamento entre elas.
    A anotação abaixo, entre outras coisas, serve para definir o nome da tabela que
    irá indicar o relacionamento entre as tabelas atores e filmes.
    Já o 'joinColumns' e 'inverseJoinColimns' define (por ordem) o nome da coluna
    no BD que servirá como chave e a variável da classe que representa a chave.
    o primeiro join representa a classe na qual ele está presente e o segundo representa
    a outra classe do relacionamento.
     */
    @JoinTable(name = "atores_filmes",
            joinColumns = @JoinColumn(name = "filme_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "ator_id", referencedColumnName = "id")
    )
    private List<Ator> atores;

    public Filme() {
    }

    public Filme(String nome, Double nota) {
        this.nome = nome;
        this.nota = nota;
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

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }

    /*
    A verificação serve para checar se a lista não está apontando para nulo.
    Caso esteja, cria-se uma lista. Isso serve para, entre outras coisas, evitar
    erros no método adicionarAtores.
     */
    public List<Ator> getAtores() {
        if (atores == null) {
            atores = new ArrayList<>();
        }
        return atores;
    }

    public void setAtores(List<Ator> atores) {
        this.atores = atores;
    }

    /*
    O método abaixo serve para garantir a relação bidirecional.
    Repare que na classe que adiciona tios e sobrinhos, é necessário realizar este
    procedimento de forma manual.
    Esse método, além de adicionar em ambos os objetos, verifica se o objeto 'ator'
    informado está ou não nulo ou se esse ator já foi adicionado.
    Da mesma forma, ao adicionar o filme, é verificado se o filme já está vinculado
    ao ator.
     */
    public void adicionarAtor(Ator ator) {
        if (ator != null && !getAtores().contains(ator)) {
            getAtores().add(ator);
            if (!ator.getFilmes().contains(this)) {
                ator.getFilmes().add(this);
            }
        }
    }
}

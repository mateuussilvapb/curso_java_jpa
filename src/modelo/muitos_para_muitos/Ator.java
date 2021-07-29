package modelo.muitos_para_muitos;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "atores")
public class Ator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    /*
    Utilizando a notação cascade = CascadeType.PERSIST no ManyToMany, ao adicionar
    um ator no método principal, caso haja algum filme vinculado ao objeto, esses 
    filmes também serão persistidos automaticamente.
    Para acontecer o inverso (adicionar um filme e automaticamente adicionar um ator)
    é necessário colocar a anotação também em filme.
    */
    @ManyToMany(mappedBy = "atores", cascade = CascadeType.PERSIST)
    private List<Filme> filmes = new ArrayList<>();

    public Ator() {
    }

    public Ator(String nome) {
        this.nome = nome;
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

    public List<Filme> getFilmes() {
        return filmes;
    }

    public void setFilmes(List<Filme> filmes) {
        this.filmes = filmes;
    }

}

package modelo.um_pra_um;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "clientes", schema = "curso_java")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    /*
    A anotação OneToOne representa o tio de relacionamento que esta classe tem
    com a classe assento.
    Cascade indica que o desenvolvedor que gerar uma operação em cascata. Pode 
    ser informado apenas uma situação na qual a operação será realizada, ou um
    conjunto de situações.
    */
    @OneToOne (cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    /*
    JoinColumn é uma anotação específica para mapear campos que representam
    junções entre tabelas.
    */
    @JoinColumn (name = "assento_id", unique = true)
    private Assento assento;

    public Cliente() {
    }

    public Cliente(String nome, Assento assento) {
        this.nome = nome;
        this.assento = assento;
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

    public Assento getAssento() {
        return assento;
    }

    public void setAssento(Assento assento) {
        this.assento = assento;
    }

}

package modelo.um_pra_um;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "assentos", schema = "curso_java")
public class Assento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    /*
    Em relacionamentos bidirecionais, é necessário utilizar o atributo 'mappedBy'
    para que o JPA não crie um atribudo no BD que represente uma chave estrangeira,
    pois esse atributo já estará na outra tabela.
    */
    @OneToOne (mappedBy = "assento")
    private Cliente cliente;

    public Assento() {
    }

    public Assento(String nome) {
        this.nome = nome;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
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

}

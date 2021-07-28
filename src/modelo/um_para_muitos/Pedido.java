package modelo.um_para_muitos;

import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Date data;
    /*
    Valores padrão dos fetchs: 
        (...toMany -> Lazy)
        (...toOne -> Eager)
    */
    /*
    Observe que a classe ItemPedido está mapeada para a classe Pedido, formando 
    uma relação bidirecional. 
    No entanto, ao realizar uma consulta utilizando a classe pedido, por exemplo,
    não é feito uma consulta a tabela ItemPedido, a não ser que seja especificado
    no código. 
    Para realizar a consulta prévia ao invés da tardia, basta utilizar o atributo 
    fetch = FetchType.EAGER.
    */
    @OneToMany(mappedBy = "pedido")
    private List<ItemPedido> itens;

    public Pedido() {
        this(new Date());
    }

    public Pedido(Date data) {
        this.data = data;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public void setItens(List<ItemPedido> itens) {
        this.itens = itens;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

}

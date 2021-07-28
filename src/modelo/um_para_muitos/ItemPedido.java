package modelo.um_para_muitos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import modelo.basico.Produto;

@Entity
public class ItemPedido {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    /*
    Visto que um pedido pode possuir vários itens, a anotação 'ManyToOne' indica
    que vários itens podem estar presentes em um único pedido.
    Repare que a classe que pode ser repetida em outra possuirá a anotação descrita.
    Porém, é possível utilizar também a anotação 'OneToMany' na classe que possuirá
    vários itens. Isso irá variar de acordo com a necessidade e o contexto.
     */
    @ManyToOne
    private Pedido pedido;
    @ManyToOne
    private Produto produto;
    @Column (nullable = false)
    private Integer quantidade;
    /*
    Apesar do produto possuir um preço por si só, é importante que o pedido também
    possua, visto que é possível que o cliente realize um pedido hoje com um valor,
    mas amanhã o produto esteja mais caro ou mais barato
     */
    @Column (nullable = false)
    private Double preco;

    public ItemPedido(Pedido pedido, Produto produto, Integer quantidade) {
        this.setPedido(pedido);
        this.setProduto(produto);
        this.setQuantidade(quantidade);
    }

    public ItemPedido() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Produto getProduto() {
        return produto;
    }

    /*
    Nesse método, é verificado se o preço do item já não foi setado. se ainda não,
    é coletado o preço atual do produto e setado o preço no item.
     */
    public void setProduto(Produto produto) {
        this.produto = produto;
        if (produto != null && this.preco == null) {
            this.setPreco(produto.getPreco());
        }
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

}

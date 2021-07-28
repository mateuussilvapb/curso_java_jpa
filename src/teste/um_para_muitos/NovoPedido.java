package teste.um_para_muitos;

import infra.DAO;
import modelo.basico.Produto;
import modelo.um_para_muitos.ItemPedido;
import modelo.um_para_muitos.Pedido;

public class NovoPedido {

    public static void np(String[] args) {
        DAO<Object> dao = new DAO<>();
        Produto produto = new Produto("Geladeira", 2789.99);
        Pedido pedido = new Pedido();
        ItemPedido item = new ItemPedido(pedido, produto, 10);

        dao.abrirT()
           .incluir(produto)
           .incluir(pedido)
           .incluir(item)
           .fecharT()
           .fechar();
    }
}

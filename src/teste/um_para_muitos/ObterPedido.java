package teste.um_para_muitos;

import infra.DAO;
import modelo.um_para_muitos.ItemPedido;
import modelo.um_para_muitos.Pedido;

public class ObterPedido {

    public static void main(String[] args) {
        DAO<Pedido> dao = new DAO<>(Pedido.class);
        Pedido pedido = dao.obterPorID(1L);

        for (ItemPedido item : pedido.getItens()) {
            System.out.println(item.getQuantidade());
            System.out.println(item.getProduto().getNome());
        }

        dao.fechar();
    }
}

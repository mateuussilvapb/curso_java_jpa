package teste.basico;

import infra.ProdutoDAO;
import java.util.List;
import modelo.basico.Produto;

public class ObterProdutos {

    public static void main(String[] args) {
        ProdutoDAO dao = new ProdutoDAO();
        List<Produto> produtos = dao.obterTodos();

        for (Produto produto : produtos) {
            System.out.println(produto.getId() + " --> " + produto.getNome());
        }

        double precoTotal = produtos.
                stream().
                map(p -> p.getPreco()).
                reduce(0.0, (t, p) -> t + p).
                doubleValue();
        System.out.println("O valor total é: " + precoTotal + "R$");
        dao.fechar();
    }
}

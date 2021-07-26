package teste.basico;

import infra.DAO;
import modelo.basico.Produto;

public class NovoProduto {

    public static void nvProduto(String[] args) {
        DAO<Produto> dao = new DAO<>(Produto.class);
        Produto produto = new Produto("Monitor", 799.99);
        dao.incluirAtomico(produto).fechar();
        System.out.println("ID fo produto: " + produto.getId());
//        dao.abrirT().incluir(produto).fecharT().fechar();
    }

}

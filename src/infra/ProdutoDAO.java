package infra;

import modelo.basico.Produto;

/*
Ao criar um DAO genérico, temos duas opções: podemos definir qual tipo será trabalhado
na hora da utilização ou, por meio de herânça, informar o tipo que será usado.
Não só isso, a classe que herda também pode servir para implementar métodos específicos
para o tipo definido.
 */
public class ProdutoDAO extends DAO<Produto> {

    public ProdutoDAO() {
        super(Produto.class);
    }

}

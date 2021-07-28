package teste.um_pra_um;

import infra.DAO;
import modelo.um_pra_um.Assento;
import modelo.um_pra_um.Cliente;

public class ObterClienteAssento {

    public static void oca(String[] args) {
        /*
        Repare que com o relacionamento bidirecional, é possível coletar o nome 
        do cliente pelo assento ou o nome do assento pelo cliente.
        Observe o exemplo.
        */
        DAO<Cliente> daoCliente = new DAO<>(Cliente.class);
        Cliente cliente = daoCliente.obterPorID(4L);
        System.out.println(cliente.getAssento().getNome());
        DAO<Assento> daoAssento = new DAO<>(Assento.class);
        Assento assento = daoAssento.obterPorID(1L);
        System.out.println(assento.getCliente().getNome());
        System.out.println(assento.getCliente().getAssento().getNome());
        daoAssento.fechar();
        daoCliente.fechar();
    }
}

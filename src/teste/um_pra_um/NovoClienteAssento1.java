package teste.um_pra_um;

import infra.DAO;
import modelo.um_pra_um.Assento;
import modelo.um_pra_um.Cliente;

public class NovoClienteAssento1 {

    public static void nca1(String[] args) {
        Assento assento = new Assento("61B");
        Cliente cliente = new Cliente("Renê", assento);

        DAO<Object> dao = new DAO<>(Object.class);
        dao.abrirT()
                .incluir(assento)
                .incluir(cliente)
                .fecharT()
                .fechar();

    }
}

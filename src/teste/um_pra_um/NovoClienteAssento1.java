package teste.um_pra_um;

import infra.DAO;
import modelo.um_pra_um.Assento;
import modelo.um_pra_um.Cliente;

public class NovoClienteAssento1 {

    public static void main(String[] args) {
        Assento assento = new Assento("16C");
        Cliente cliente = new Cliente("Ana", assento);

        DAO<Object> dao = new DAO<>();
        dao.abritT()
                .incluir(assento)
                .incluir(cliente)
                .fecharT()
                .fechar();

    }
}

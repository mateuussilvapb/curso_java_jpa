package teste.um_pra_um;

import infra.DAO;
import modelo.um_pra_um.Assento;
import modelo.um_pra_um.Cliente;

public class NovoClienteAssento2 {

    public static void nca2(String[] args) {

        Assento assento = new Assento("4D");
        Cliente cliente = new Cliente("Rodrigo", assento);

        /*
        Observe que mesmo não incluindo o assento antes de incluir o cliente, o 
        programa executa sem erros. Isso se dá devido a notação OneToOne (cascade)
        na classe cliente.
        Com essa notação, o JPA automatiza a operação de inserção do assento.
         */
        DAO<Cliente> dao = new DAO<>(Cliente.class);
        dao.incluirAtomico(cliente);
    }
}

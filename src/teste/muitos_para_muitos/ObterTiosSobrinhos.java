package teste.muitos_para_muitos;

import infra.DAO;
import java.util.List;
import modelo.muitos_para_muitos.Sobrinho;
import modelo.muitos_para_muitos.Tio;

public class ObterTiosSobrinhos {

    public static void ots(String[] args) {
        DAO<Tio> dao = new DAO<>(Tio.class);
        List<Tio> tios = dao.obterTodos();
        for (Tio tio : tios) {
            for (Sobrinho sobrinho: tio.getSobrinhos()) {
                System.out.println(tio.getNome() + " ---> " + sobrinho.getNome());
            }
        }
    }
}

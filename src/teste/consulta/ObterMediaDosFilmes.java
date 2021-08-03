package teste.consulta;

import infra.DAO;
import modelo.consulta.NotaFilme;

public class ObterMediaDosFilmes {

    public static void abt(String[] args) {
        DAO<NotaFilme> dao = new DAO<>(NotaFilme.class);
        NotaFilme nota = dao.consultarUm("ObterMediaDosFilmes");
        
        System.out.println(nota.getMedia());
        
        dao.fechar();

    }
}

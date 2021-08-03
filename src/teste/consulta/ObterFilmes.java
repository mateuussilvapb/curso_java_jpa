package teste.consulta;

import infra.DAO;
import java.util.List;
import modelo.muitos_para_muitos.Ator;
import modelo.muitos_para_muitos.Filme;

public class ObterFilmes {

    public static void obtFilmes(String[] args) {
        DAO<Filme> dao = new DAO<>(Filme.class);
        List<Filme> filmes = dao.consultar("filmes_nota_maior_que", "nota", 8.5);
        for (Filme filme : filmes) {
            System.out.println(filme.getNome() + " ---> " + filme.getNota());
            for (Ator ator : filme.getAtores()) {
                System.out.println(ator.getNome());
            }
        }
    }
}

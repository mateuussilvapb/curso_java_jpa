package teste.muitos_para_muitos;

import infra.DAO;
import modelo.muitos_para_muitos.Ator;
import modelo.muitos_para_muitos.Filme;

public class FilmeAtor {

    public static void fm(String[] args) {
        Filme filmeA = new Filme("Star Wars Ep 4", 8.9);
        Filme filmeB = new Filme("O fugitivo", 8.1);

        Ator atorA = new Ator("Harrison Ford");
        Ator atrizB = new Ator("Carrie Fisher");

        filmeA.adicionarAtor(atorA);
        filmeA.adicionarAtor(atrizB);

        filmeB.adicionarAtor(atorA);

        DAO<Filme> dao = new DAO<>();

        dao.incluirAtomico(filmeA);
    }
}

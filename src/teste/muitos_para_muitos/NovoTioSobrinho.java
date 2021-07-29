package teste.muitos_para_muitos;

import infra.DAO;
import modelo.muitos_para_muitos.Sobrinho;
import modelo.muitos_para_muitos.Tio;

public class NovoTioSobrinho {

    public static void nst(String[] args) {
        Tio tio = new Tio("João");
        Tio tia = new Tio("Maria");

        Sobrinho sobrinha = new Sobrinho("Ana");
        Sobrinho sobrinho = new Sobrinho("Davi");

        tia.getSobrinhos().add(sobrinho);
        tia.getSobrinhos().add(sobrinha);
        tio.getSobrinhos().add(sobrinho);
        tio.getSobrinhos().add(sobrinha);

        sobrinho.getTios().add(tia);
        sobrinha.getTios().add(tia);
        sobrinho.getTios().add(tio);
        sobrinha.getTios().add(tio);

        DAO<Object> dao = new DAO<>();
        dao.abrirT()
                .incluir(tia)
                .incluir(tio)
                .incluir(sobrinha)
                .incluir(sobrinho)
                .fecharT()
                .fechar();

    }
}

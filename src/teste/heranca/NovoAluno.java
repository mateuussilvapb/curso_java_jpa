package teste.heranca;

import desafio.modelo.heranca.Aluno;
import desafio.modelo.heranca.AlunoBolsista;
import infra.DAO;

public class NovoAluno {

    public static void nvAluno(String[] args) {
        DAO<Aluno> dao = new DAO<>(Aluno.class);
        Aluno aluno1 = new Aluno(123L, "João");
        AlunoBolsista aluno2 = new AlunoBolsista((double) 1000, 345L, "Maria");
        dao.incluirAtomico(aluno1);
        dao.incluirAtomico(aluno2);
        dao.fechar();
    }
}

package teste.basico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import modelo.basico.Usuario;

public class NovoUsuario {

    public static void main(String[] args) {

        /*
        Classe resposável por criar o EntityManager. Ela é necessária visto que
        é possível acessar mais de um banco de dados pelo JPA, o que requer mais 
        de uma conexão.
         */
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("curso_java");
        /*
        Classe resposável por realizar a inserção, remoção, atualização, exclusão
        e gerenciamento das entidades mapeadas.
         */
        EntityManager em = emf.createEntityManager();

        Usuario novoUsuario = new Usuario("Mateus", "mateuussilvapb@gmail.com");
        em.persist(novoUsuario);
        em.close();
        emf.close();
    }
}

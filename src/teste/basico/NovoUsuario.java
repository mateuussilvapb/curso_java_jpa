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
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios-jpa");
        /*
        Classe resposável por realizar a inserção, remoção, atualização, exclusão
        e gerenciamento das entidades mapeadas.
         */
        EntityManager em = emf.createEntityManager();

        Usuario novoUsuario = new Usuario("Maria", "mariaaddesterro@gmail.com");
        /*
        O trecho 'em.getTransaction().begin();' indica ao código que uma transação
        com o banco de dados será iniciada nesse momento.
         */
        em.getTransaction().begin();
        /*
        'persist' insere uma informação no banco de dados. Em outras palavras, ele
        irá gerar um 'insert'
         */
        em.persist(novoUsuario);
        /*
        O trecho 'em.getTransaction().commit();' dá o 'commit', ou seja, informa que
        todas as transações foram realizadas e dá o comando de efetivamente realizar
        as alterações no banco de dados.
         */
        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}

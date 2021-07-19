package teste.basico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import modelo.basico.Usuario;

public class AlterarUsuario1 {
    public static void altUsuario(String[] args) {
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
        
        em.getTransaction().begin();
        Usuario usuario = em.find(Usuario.class, 4L);
        usuario.setNome("Teste");
        usuario.setEmail("testee@gmail.com");
        /*
        O comando 'merge' é o equivalente ao update. Com ele é possível alterar um
        usuário já existente no banco de dados.
        */
        em.merge(usuario);
        em.getTransaction().commit();
        
        em.close();
        emf.close();
    }
}

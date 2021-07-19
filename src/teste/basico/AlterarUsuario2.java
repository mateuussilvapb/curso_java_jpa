package teste.basico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import modelo.basico.Usuario;

public class AlterarUsuario2 {

    public static void altUsuario2(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios-jpa");
        EntityManager em = emf.createEntityManager();
        
        /*
        No trecho de código abaixo repare que o método merge que serve para realizar
        uma atualização no banco de dados está comentado, ou seja, ele não está sendo
        executado.
        Apesar disso, a atualização é feita. Isso se dá pois a consulta realizada
        está dentro de um contexto transacional. Dessa forma, o objeto consultado
        fica em um estado gerenciado, sendo que quando ocorre uma alteração no objeto
        o JPA entende que essa alteração deve repercutir no banco de dados também.
        Mesmo que a consulta não estivesse delimitada dentro de uma transação, o JPA 
        realizaria a atualização, visto que mesmo assim o objeto estaria no estado 
        gerenciado.
        */
        em.getTransaction().begin();
        Usuario usuario = em.find(Usuario.class, 4L);
        usuario.setNome("Marcos Dias");
        usuario.setEmail("marcospavs@gmail.com");
//        em.merge(usuario); 
        em.getTransaction().commit();
        
        em.close();
        emf.close();
    }
}

package teste.basico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import modelo.basico.Usuario;

public class AlterarUsuario3 {

    public static void altUsuario(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios-jpa");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Usuario usuario = em.find(Usuario.class, 1L);
        /*
        Na classe AlterarUsuario2 foi visto que, mesmo sem utilizar o método merge,
        o JPA realiza a alteração no banco de dados.
        Para que o objeto não fique em um estado transacional e por consequência, 
        não fique gerenciado, basta utilizar o método detach e passar como parâmetro
        o objeto do qual você não quer que seja monitorado. Dessa forma, a utilização
        do método merge é necessária, caso você queira que alguma alteração seja 
        realizada no banco de dados.
         */
        em.detach(usuario);
        usuario.setNome("Chagas");
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}

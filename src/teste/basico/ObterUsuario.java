package teste.basico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import modelo.basico.Usuario;

public class ObterUsuario {

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
        /*
        O método 'find' recupera uma informação do banco de dados de acordo com 
        os parâmetros passados. O primeiro parâmetro representa a classe que deve
        servir como base para o mapeamento. O segundo parâmetro é o item que
        servirá como pesquisa.
         */
        Usuario usuario = em.find(Usuario.class, 1L);
        System.out.println(usuario.getNome());
        em.close();
        emf.close();
    }
}

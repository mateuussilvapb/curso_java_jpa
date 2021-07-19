package teste.basico;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import modelo.basico.Usuario;

public class ObterUsuarios {

    public static void obtUsuarios(String[] args) {
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
        'jpql' refere-se a 'Java Persistence Query Language'.  Observe que o local
        onde ficaria o nome da tabela no mySql foi substituido pelo nome da entidade.
        Isso se dá pois o JPA realiza o mapeamento entre o objeto e a tabela, não
        sendo necessário realizar a consulta diretamente no mySql.
         */
        String jpql = "SELECT u FROM Usuario u";
        /*
        O trecho abaixo armazena o resultado da consulta ao BD. Repare que ao final
        é utilizado a nomenclatura 'Usuario.class'. Isso serve para recuperar os 
        metadados da classe usuário. Ou seja, recupera as informações sobre a classe
        'Usuario': seus métodos, atributos, entre outros. Isso se chama 'Reflection'.
        O JPA utiliza bastante 'Reflection' para realizar o mapeamento dos objetos.
         */
        TypedQuery<Usuario> query = em.createQuery(jpql, Usuario.class);
        /*
        O trecho abaixo serve para alterar a quantidade máxima de registros a serem
        armazenados. Em alguns casos, isso é necessário devido a grande quantidade
        de registros em um banco de dados. 
         */
        query.setMaxResults(5);
        List<Usuario> usuarios = query.getResultList();
        /*
        Existe outra forma de armazenar os resultados.
         */
//        List<Usuario> usuarios = em.createQuery("SELECT u FROM Usuario u", Usuario.class).
//                setMaxResults(5).
//                getResultList();
        for (Usuario usuario : usuarios) {
            System.out.println("ID: " + usuario.getId() + " - " + usuario.getNome() + " - " + usuario.getEmail());
        }
        em.close();
        emf.close();
    }
}

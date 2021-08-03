package infra;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/*
O <E> deixa a classe genérica. Ou seja, qualquer outra classe que defina um objeto
poderá utilizá-la.
 */
public class DAO<E> {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios-jpa");
    private EntityManager em;
    private Class<E> classe;

    /*
    Atributos estáticos podem ser inicializados diretamente em sua própria criação
    ou utilizando blocos estáticos.
    O bloco estático é executado apenas uma vez no momento da criação da classe.
     */
//    static {
//        try {
//            emf = Persistence.createEntityManagerFactory("exercicios-jpa");
//        } catch (Exception e) {
//            System.out.println("ERRO NO BLOCO ESTÁTICO DA CLASSE DAO: " + e);
//            /*
//            Também pode ser utilizado o log4j(api)
//             */
//        }
//    }

    /*
    Atributos de instância podem ser inicializados no construtor.
    Visto que é necessário saber qual a classe do objeto que está utilizando o DAO,
    é necessário que essa classe seja passada na construção.
     */
    public DAO(Class<E> classe) {
        this.classe = classe;
        em = emf.createEntityManager();
    }

    public DAO() {
        this(null);
    }

    public DAO<E> abrirT() {
        em.getTransaction().begin();
        return this;
    }

    public DAO<E> fecharT() {
        em.getTransaction().commit();
        return this;
    }

    public DAO<E> incluir(E entidade) {
        em.persist(entidade);
        return this;
    }

    public DAO<E> incluirAtomico(E entidade) {
        /*
        A linha abaixo só é possível devido os métodos invocados nela retornarem
        a própria classe DAO.
         */
        this.abrirT().incluir(entidade).fecharT();
        return this;
    }

    public E obterPorID(Object id) {
        return em.find(classe, id);
    }

    /*
    Em banco de dados, limit define a quantidade de registros que se quer exibir
    de uma consulta geral.
    Já o offset define o deslocamento da consulta.
    Ex.: se uma tabela possui 10 registros e é setado 5 como limit e 3 como offset,
    a consulta retornará do 4º ao 8º registro.
     */
    public List<E> obterTodos(int limit, int offset) {
        if (classe == null) {
            throw new UnsupportedOperationException("Classe nula.");
        }
        /*
        Toda consulta em jpql precisa de um alias(apelido)
         */
        String jpql = "SELECT e FROM " + classe.getName() + " e";
        TypedQuery<E> query = em.createQuery(jpql, classe);
        query.setMaxResults(limit);
        query.setFirstResult(offset);
        return query.getResultList();
    }

    /*
    De forma opcional, é possível criar um método semelhante ao 'obterTodos', mas
    com um valor padrão para os parâmetros.
     */
    public List<E> obterTodos() {
        return this.obterTodos(10, 0);
    }

    public void fechar() {
        /*
        O 'emf' não pode ser fechado visto que é estático e, por isso, é utilizado
        por todos os objetos do tipo DAO.
         */
        em.close();
    }

//    public static void main(String[] args) {
//        new DAO<Produto>().teste().teste().teste();
//    }
    public List<E> consultar(String nomeConsulta, Object... params) {
        TypedQuery<E> query = em.createNamedQuery(nomeConsulta, classe);
        for (int i = 0; i < params.length; i += 2) {
            query.setParameter(params[i].toString(), params[i + 1]);
        }
        return query.getResultList();
    }
    
    public E consultarUm(String nomeConsulta, Object... params) {
        List<E> lista = consultar(nomeConsulta, params);
        return lista.isEmpty() ? null : lista.get(0);
    }
}

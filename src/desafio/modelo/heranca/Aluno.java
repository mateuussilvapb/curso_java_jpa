package desafio.modelo.heranca;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/*
A anotação Inheritance é utilizada quando se utiliza herença.
Essa anotação possui 3 estratégias distintas.
    
    1. A estratégia TABLE_PER_CLASS cria, para cada classe, uma tabela 
    correspondente no BD;
    
    2. A estratégia SINGLE_TABLE cria uma única tabela para todas as 
    classes que participam da herança, além de coletar os atributos 
    de todas elas e colocar em uma única tabela. 
        
        2.1. Para que essa estratégia funcione melhor, é necessário 
        utilizar também a anotação DiscriminatorColumn, que serve 
        para criar uma coluna no banco de dados para diferenciar 
        as classes que participam da herança.
        
        2.2. Com isso, é necessário especificar em cada classe qual
        o valor que a identifica, utilizando a notação DiscriminatorValue.
        Dessa forma, ao instanciar um aluno, automaticamente o JPA irá 
        atribuir o valor "AL", na coluna tipo no banco de dados.
        Caso um aluno bolsista seja instanciado, o valor atribuído será
        "AB".
    
    3. A estratégia JOINED é semelhante a TABLE_PER_CLASS. Ela cria, para 
    cada classe, uma tabela correspondente no banco de dados. Porém, a 
    diferença é que a tabela aluno, por exemplo, ainda possuirá a coluna
    tipo. Já a tabela alunoBolsista, possuirá apenas a matrícula e o valor
    da bolsa, visto que são essas duas informações que diferenciam uma aluno
    bolsista de um não bolsista.
    
*/
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "tipo", length = 2, discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("AL")
public class Aluno {

    @Id
    private Long matricula;
    private String nome;

    public Aluno() {
    }

    public Aluno(Long matricula, String nome) {
        this.matricula = matricula;
        this.nome = nome;
    }

    public Long getMatricula() {
        return matricula;
    }

    public void setMatricula(Long matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}

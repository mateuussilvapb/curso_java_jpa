package desafio.modelo.heranca;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("AB")
public class AlunoBolsista extends Aluno {

    private Double valorBolsa;

    public AlunoBolsista() {
    }

    public AlunoBolsista(Double valorBolsa, Long matricula, String nome) {
        super(matricula, nome);
        this.valorBolsa = valorBolsa;
    }

    public Double getValorBolsa() {
        return valorBolsa;
    }

    public void setValorBolsa(Double valorBolsa) {
        this.valorBolsa = valorBolsa;
    }
}

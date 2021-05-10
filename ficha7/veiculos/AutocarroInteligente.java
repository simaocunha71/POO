package veiculos;

import java.util.ArrayList;

public class AutocarroInteligente extends Veiculo implements BonificaKms {
    private int lotacao;
    private int ocupacao;
    private int fatorKm;

    public AutocarroInteligente() {
        super();
        this.lotacao = 0;
        this.ocupacao = 0;
        this.fatorKm = 0;
    }

    public AutocarroInteligente(String marca, String modelo, String matricula, int ano, double velocidadeMedia,
            double precokm, ArrayList<Integer> classificacao, int kms, int kmsUltimo) {
        super(marca, modelo, matricula, ano, velocidadeMedia, precokm, classificacao, kms, kmsUltimo);
        this.lotacao = 0;
        this.ocupacao = 0;
        this.fatorKm = 0;
    }

    public AutocarroInteligente(String marca, String modelo, String matricula, int ano, double velocidadeMedia,
            double precokm, ArrayList<Integer> classificacao, int kms, int kmsUltimo, int lotacao) {
        super(marca, modelo, matricula, ano, velocidadeMedia, precokm, classificacao, kms, kmsUltimo);
        this.lotacao = lotacao;
        this.ocupacao = 0;
        this.fatorKm = 0;
    }

    public AutocarroInteligente(String marca, String modelo, String matricula, int ano, double velocidadeMedia,
            double precokm, ArrayList<Integer> classificacao, int kms, int kmsUltimo, int lotacao, int ocupacao) {
        super(marca, modelo, matricula, ano, velocidadeMedia, precokm, classificacao, kms, kmsUltimo);
        this.lotacao = lotacao;
        this.ocupacao = ocupacao;
        this.fatorKm = 0;
    }

    public AutocarroInteligente(String marca, String modelo, String matricula, int ano, double velocidadeMedia,
            double precokm, ArrayList<Integer> classificacao, int kms, int kmsUltimo, int lotacao, int ocupacao,
            int fatorKm) {
        super(marca, modelo, matricula, ano, velocidadeMedia, precokm, classificacao, kms, kmsUltimo);
        this.lotacao = lotacao;
        this.ocupacao = ocupacao;
        this.fatorKm = fatorKm;
    }

    public AutocarroInteligente(AutocarroInteligente ai) {
        super(ai);
        this.lotacao = ai.getLotacao();
        this.ocupacao = ai.getOcupacao();
        this.fatorKm = ai.getFatorKm();
    }

    public AutocarroInteligente clone() {
        return new AutocarroInteligente(this);
    }

    public boolean equals(Object o) {
        if (o == this)
            return true;
        else if (o == null || this.getClass() != o.getClass())
            return false;
        AutocarroInteligente ai = (AutocarroInteligente) o;
        return (super.equals(ai) && this.lotacao == ai.getLotacao() && this.ocupacao == ai.getOcupacao());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("AutocarroInteligente:{ \n").append(super.toString()).append("\nLotação: ")
                .append(lotacao).append("\nOcupação: ").append(ocupacao).append("\n}\n");
        return sb.toString();
    }

    public int getLotacao() {
        return this.lotacao;
    }

    public void setLotacao(int lotacao) {
        this.lotacao = lotacao;
    }

    public int getOcupacao() {
        return this.ocupacao;
    }

    public void setOcupacao(int ocupacao) {
        this.ocupacao = ocupacao;
    }

    @Override
    public double getCustoRealKM() {
        double aux = (double) ocupacao / lotacao;
        if (aux > 0.6)
            return custoRealKM() * 0.25;
        return custoRealKM() * 0.5;
    }

    public void setFatorKm(int fatorKm) {
        this.fatorKm = fatorKm;
    }

    public int getFatorKm() {
        return this.fatorKm;
    }
}
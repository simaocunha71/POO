package veiculos;

import java.util.ArrayList;

public class VeiculoPremium extends Veiculo implements BonificaKms {
    private double taxaDeLuxo;
    private int fatorKm;

    public VeiculoPremium() {
        super();
        this.taxaDeLuxo = 0;
        this.fatorKm = 0;
    }

    public VeiculoPremium(String marca, String modelo, String matricula, int ano, double velocidadeMedia, double precokm,
            ArrayList<Integer> classificacao, int kms, int kmsUltimo) {
        super(marca, modelo, matricula, ano, velocidadeMedia, precokm, classificacao, kms, kmsUltimo);
        this.taxaDeLuxo = 0;
        this.fatorKm = 0;
    }

    public VeiculoPremium(String marca, String modelo, String matricula, int ano, double velocidadeMedia, double precokm,
            ArrayList<Integer> classificacao, int kms, int kmsUltimo, double taxaDeLuxo) {
        super(marca, modelo, matricula, ano, velocidadeMedia, precokm, classificacao, kms, kmsUltimo);
        this.taxaDeLuxo = taxaDeLuxo;
        this.fatorKm = 0;
    }

    public VeiculoPremium(Veiculo v, double taxaDeLuxo) {
        super(v);
        this.taxaDeLuxo = taxaDeLuxo;
        this.fatorKm = 0;
    }

    public VeiculoPremium(Veiculo v, double taxaDeLuxo, int fatorKm) {
        super(v);
        this.taxaDeLuxo = taxaDeLuxo;
        this.fatorKm = fatorKm;
    }

    public VeiculoPremium(String marca, String modelo, String matricula, int ano, double velocidadeMedia, double precokm,
            ArrayList<Integer> classificacao, int kms, int kmsUltimo, double taxaDeLuxo, int fatorKm) {
        super(marca, modelo, matricula, ano, velocidadeMedia, precokm, classificacao, kms, kmsUltimo);
        this.taxaDeLuxo = taxaDeLuxo;
        this.fatorKm = fatorKm;
    }

    public VeiculoPremium(Veiculo v) {
        super(v);
        this.taxaDeLuxo = 0;
        this.fatorKm = 0;
    }

    public VeiculoPremium(VeiculoPremium vp) {
        super(vp);
        this.taxaDeLuxo = vp.getTaxaDeLuxo();
        this.fatorKm = vp.getFatorKm();
    }

    public VeiculoPremium clone() {
        return new VeiculoPremium(this);
    }

    public double getTaxaDeLuxo() {
        return this.taxaDeLuxo;
    }

    public void setTaxaDeLuxo(double taxaDeLuxo) {
        this.taxaDeLuxo = taxaDeLuxo;
    }

    public boolean equals(Object o) {
        if (o == this)
            return true;
        else if (o == null || this.getClass() != o.getClass())
            return false;
        VeiculoPremium vp = (VeiculoPremium) o;
        return (super.equals(o) && vp.getTaxaDeLuxo() == this.taxaDeLuxo);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Premium:{\n").append(super.toString()).append("\nTaxa de Luxo: ")
                .append(taxaDeLuxo).append("\n}\n");
        return sb.toString();
    }

    @Override
    public double getCustoRealKM() {
        return custoRealKM() * this.taxaDeLuxo;
    }

    public void setFatorKm(int fatorKm) {
        this.fatorKm = fatorKm;
    }

    public int getFatorKm() {
        return this.fatorKm;
    }
}

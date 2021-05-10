package veiculos;

import java.util.ArrayList;

public class VeiculoOcasiao extends Veiculo {
    private boolean desconto;

    public VeiculoOcasiao() {
        super();
        this.desconto = false;
    }

    public VeiculoOcasiao(String marca, String modelo, String matricula, int ano, double velocidadeMedia, double precokm,
            ArrayList<Integer> classificacao, int kms, int kmsUltimo) {
        super(marca, modelo, matricula, ano, velocidadeMedia, precokm, classificacao, kms, kmsUltimo);
        this.desconto = false;
    }

    public VeiculoOcasiao(String marca, String modelo, String matricula, int ano, double velocidadeMedia, double precokm,
            ArrayList<Integer> classificacao, int kms, int kmsUltimo, boolean desconto) {
        super(marca, modelo, matricula, ano, velocidadeMedia, precokm, classificacao, kms, kmsUltimo);
        this.desconto = desconto;
    }

    public VeiculoOcasiao(Veiculo v, boolean desconto) {
        super(v);
        this.desconto = desconto;
    }

    public VeiculoOcasiao(Veiculo v) {
        super(v);
        this.desconto = false;
    }

    public VeiculoOcasiao(VeiculoOcasiao vo) {
        super(vo);
        this.desconto = vo.getDesconto();
    }

    public VeiculoOcasiao clone() {
        return new VeiculoOcasiao(this);
    }

    public boolean equals(Object o) {
        if (this == o)
            return true;
        else if (o == null || this.getClass() != o.getClass())
            return false;
        VeiculoOcasiao vo = (VeiculoOcasiao) o;
        return (super.equals(o) && this.desconto == vo.getDesconto());
    }

    public boolean getDesconto() {
        return this.desconto;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Ocasião:\n").append(super.toString())
                               .append("\nEm desconto: ").append(desconto).append("\n\n");
        return sb.toString();
    }

    public void setdesconto(boolean desconto) {
        this.desconto = desconto;
    }

    @Override
    public double getCustoRealKM() {
        return (desconto ? custoRealKM() * 0.75 : custoRealKM());
    }
}
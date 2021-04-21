package veiculos;

public class VeiculoOcasiao extends Veiculo{  
    private boolean promocao;
    
    public VeiculoOcasiao(String marca, String modelo, String matricula,
                          int ano, double velociademedia, double precokm,
                          ArrayList<Integer> classificacao,
                          int kms, int kmsUltimo, boolean promocao){
        super(marca,modelo,matricula,ano,velociademedia, precokm, classificacao, kms, kmsUltimo);
        this.setPromocao(promocao);
    }

    public VeiculoOcasiao(){
        super();
        this.promocao = false;
    }

    public VeiculoOcasiao(VeiculoOcasiao vo){
        super(vo);
        this.promocao = vo.getPromocao();
    }

    public Boolean getPromocao(){
        return this.promocao;
    }

    public void setPromocao(boolean p){
        this.promocao = p;
    }

    public double custoRealKM(){
        double preco = super.custoRealKM();
        if (this.promocao)
            preco *= 0.75;
        return preco;
    }

    public VeiculoOcasiao clone(){
        return new VeiculoOcasiao(this);
    }

    public boolean equals(Object o){
        if (o == this) return true;
        if (o == null || ! o.getClass().equals(this.getClass())) return false;
        VeiculoOcasiao vo = (VeiculoOcasiao) o;
        return  super.equals() && this.promocao == vo.getPromocao();
    }

    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        if (this.promocao)
            sb.append("Promoçao: Sim");
        else
            sb.append("Promoção: Não");
    
        return sb.toString();
    }
}

package veiculos;

import java.util.Map;
import java.util.stream.Collectors;

public class Driveit {
    public String nome;
    public Map<String,Veiculo> stand = new HashMap();

    public Driveit(String nome, Map<String,Veiculo> stand){
        this.nome = nome;
        this.stand = stand.entrySet().stream().collect(Collectors.toMap(e->e.getKey(), e->e.getValue().clone()));
    }

    public Driveit(){
        this.nome = "n/d";
        this.stand = new HashMap();
    }

    public Driveit(Driveit d){
        this.nome = d.getNome();
        this.stand = d.getStand();
    }

    public Map<String, Veiculo> getStand() {
        return stand;
    }

    public void setStand(Map<String, Veiculo> stand) {
        this.stand = stand;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public Driveit clone(){
        return new Driveit(this);
    }

    public boolean equals(Object o){
        if (o == this) return true;
        if (o == null || ! o.getClass().equals(this.getClass())) return false;
        Driveit di = (Driveit) o;
        return  this.nome == di.getNome() && this.stand.equals(di.getStand());
    }

    public boolean existeVeiculo (String mat){
        return this.stand.containsKey(mat);
    }

    public int quantos(){
        return this.stand.size();
    }

    
    /*
    public String toString() {
        final StringBuilder sb = new StringBuilder("Carro: {");
        sb.append("Marca: ").append(marca);
        sb.append(", Modelo: ").append(modelo);
        sb.append(", Matricula: ").append(matricula);
        sb.append(", Ano: ").append(ano);
        sb.append(", Velocidade média: ").append(velociademedia);
        sb.append(", Preço/km: ").append(precokm);
        sb.append(", Classificaçao: ").append(classificacao.toString());
        sb.append(", Kms: ").append(kms);
        sb.append(", Km na ultima viagem: ").append(kmsUltimo);
        sb.append("}");
        return sb.toString();
    }*/
}

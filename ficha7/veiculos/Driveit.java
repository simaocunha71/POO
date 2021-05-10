package veiculos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Driveit {
    private Map<String, Veiculo> stand;

    public Driveit() {
        this.stand = new HashMap<>();
    }

    public Driveit(Map<String, Veiculo> m) {
        this.setStand(m);
    }

    public Driveit(Driveit di) {
        this.setStand(di.getStand());
    }

    public Driveit clone() {
        return new Driveit(this);
    }

    public void setStand(Map<String, Veiculo> m) {
        this.stand = new HashMap<>();
        for (Map.Entry<String, Veiculo> me : m.entrySet())
            this.stand.put(me.getKey(), me.getValue());
    }

    public Map<String, Veiculo> getStand() {
        return this.stand.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, e -> e.getValue().clone()));
    }

    public boolean equals(Object o) {
        if (this == o)
            return true;
        else if (o == null || this.getClass() != o.getClass())
            return false;
        Driveit di = (Driveit) o;
        return (stand.equals(di.getVeiculos()));
    }

    /**
     * Verifica se existe um veiculo, dando o seu código (hash value)
     * @param cod Hash Value
     * @return true se existe, false caso contrário
     */
    public boolean existeVeiculo(String cod) {
        return this.stand.containsKey(cod);
    }

    /**
     * Calcula o numero de carros num stand
     * @return numero de carros num stand
     */
    public int quantos() {
        return this.stand.size();
    }

    /**
     * Devolve o veiculo com um determinado codigo
     * @param cod Codigo do veiculo(matricula) - hash value do veiculo
     * @return Veiculo
     */
    public Veiculo getVeiculo(String cod) {
        return this.stand.get(cod);
    }

    /**
     * Adiciona um veiculo com um determinado codigo(matricula)
     * @param v Veiculo a adicionar
     */
    public void adiciona(Veiculo v) {
        this.stand.put(v.getMatricula(), v);
    }

    /**
     * Devolve uma lista com uma cópia de todos os veiculos que existem numa hashmap
     * @return Lista de veiculos
     */
    public List<Veiculo> getVeiculos() {
        List<Veiculo> ans = new ArrayList<>();
        for (Map.Entry<String, Veiculo> m : this.stand.entrySet())
            ans.add(m.getValue());
        return ans;
    }

    /**
     * Adicionar a informação de um conjunto de veículos que foram adquiridos e passam agora a fazer parte da empresa
     * Set<E>: coleçao que não contem elementos repetidos
     * @param vs Coleçao de veiculos
     */
    public void adiciona(Set<Veiculo> vs) {
        for (Veiculo v : vs)
            this.adiciona(v.clone());
    }

    /**
     * Regista o numero de quilometros realizados por um veiculo (dado pela sua matricula)
     * @param codVeiculo Matricula de um veiculo (hash value)
     * @param numKms Numero de quilometros realizados
     */
    public void registarAluguer(String codVeiculo, int numKms) {
        if (this.stand.get(codVeiculo) != null)
            this.stand.get(codVeiculo).addViagem(numKms);
    }

    /**
     * Caracteriza um veiculo com uma classificaçao dada por um utilizador de um veiculo
     * @param cod Matricula de um veiculo
     * @param classificacao Classificaçao dada por um utilizador
     */
    public void classificarVeiculo(String cod, int classificacao) {
        if (this.stand.get(cod) != null && classificacao >= 0 && classificacao <= 10)
            this.stand.get(cod).addClassificacao(classificacao);
    }

    /**
     * Devolve o custo real em km de um veiculo
     * @param cod Matricula de um veiculo
     * @return Custo real em km
     */
    public int custoRealKm(String cod) {
        return (int) this.stand.get(cod).custoRealKM();
    }

}
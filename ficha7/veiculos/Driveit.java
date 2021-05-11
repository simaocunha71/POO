package veiculos;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Driveit {
    private Map<String, Veiculo> stand;
    private boolean desconto;

    public Driveit() {
        this.stand = new HashMap<>();
        this.desconto = false;
    }

    public Driveit(Map<String, Veiculo> m, boolean desconto) {
        this.setStand(m);
        this.setDesconto(desconto);
    }

    public Driveit(Driveit di) {
        this.setStand(di.getStand());
        this.setDesconto(di.getDesconto());
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

    public void setDesconto(boolean desconto) {
        this.desconto = desconto;
    }

    public boolean getDesconto() {
        return this.desconto;
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
        List<Veiculo> r = new ArrayList<>();
        for (Map.Entry<String, Veiculo> m : this.stand.entrySet())
            r.add(m.getValue());
        return r;
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
    public void registarAluguer(String codVeiculo, int numKms) throws VeiculoJaExistenteException {
        if (this.stand.get(codVeiculo) != null)
            this.stand.get(codVeiculo).addViagem(numKms);
        else
            throw new VeiculoJaExistenteException("Esse veiculo ("+codVeiculo+") ja existe no stand");
    }

    /**
     * Caracteriza um veiculo com uma classificaçao dada por um utilizador de um veiculo
     * @param cod Matricula de um veiculo
     * @param classificacao Classificaçao dada por um utilizador
     */
    public void classificarVeiculo(String cod, int classificacao) throws VeiculoNaoEncontradoException, ValorInvalido {
        if (this.stand.get(cod) == null)
            throw new VeiculoNaoEncontradoException("Veiculo " + cod + " não existe");
        if (classificacao >= 0 && classificacao <= 10)
            throw new ValorInvalido("A classificação deve ser um valor entre 0 e 10");
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

    /**
     * Calcula quantos veiculos existem de um tipo dado
     * toString().split(" ")[1] -> (semelhante ao strsep do C)
     *                          -> Devolve a segunda string (a que se encontra à direita do primeiro " ")
     * @param tipo Tipo do veiculo
     * @return Numero de veiculos de um dado tipo
     */
    public int quantosT(String tipo){
        return (int) this.stand.values().stream().filter(v -> v.getClass().toString().split(" ")[1].equals(tipo))
                .count();
    }

    /**
     * Coloca numa lista todos os veiculos ordenados descrescentemente de acordo com o seu preço por km
     * @return Lista de veiculos
     */
    public List<Veiculo> veiculosOrdenadosCusto(){
        return this.stand.values().stream().sorted(Comparator.comparingDouble(Veiculo::getPrecokm).reversed())
                .collect(Collectors.toList());
    }

    /**
     * Devolve o veiculo com menor preço por km
     * @return Veiculo
     * @throws VeiculoNaoEncontradoException Erro de procurar um veiculo num stand vazio
     */
    public Veiculo veiculoMaisBarato() throws VeiculoNaoEncontradoException {
        if (this.stand.size() > 0) {
            List<Veiculo> st = veiculosOrdenadosCusto();
            return st.get(st.size() - 1); //ultimo elemento de lista de veiculos
        } else
            throw new VeiculoNaoEncontradoException("Não existem veículos na empresa. Tenta outra vez");
    }

    /**
     * Devolve o veiculo menos utilizado (ou seja, aquele que tem o menor valor de kms efetuados)
     * @return Veiculo menos utilizado
     * @throws VeiculoNaoEncontradoException Erro de procurar um veiculo num stand vazio
     */
    public Veiculo menosUtilizado() throws VeiculoNaoEncontradoException {
        if (this.stand.size() > 0) {
            int min = Integer.MAX_VALUE; // Valor dos quilometros maior possível
            Veiculo r = null;
            for (Veiculo v : this.stand.values())
                if (v.getKms() < min) {
                    min = v.getKms();
                    r = v;
                }
            return r;
        } else
            throw new VeiculoNaoEncontradoException("Não existem veículos na empresa. Tenta outra vez");
    }

    /**
     * Coloca a empresa de aluguer em modo de promoção, sendo que só se aplica aos VeiculoOcasiao, ou acabar com a promoção.
     * v instanceof VeiculoOcasiao : verifica se v é do tipo VeiculoOcasiao
     * @param estado Estado de promoção
     */
    public void alteraPromocao(boolean estado) {
        this.setDesconto(estado);
        this.stand.values().stream().filter(v -> v instanceof VeiculoOcasiao)
                .forEach(v -> ((VeiculoOcasiao) v).setDesconto(estado));
    }

    /**
     * Obtem a lista dos veículos que atribuem pontos.
     * @return Lista dos veiculos
     */
    public List<BonificaKms> daoPontos() {
        return this.stand.values().stream().filter(v -> v instanceof BonificaKms).map(v -> (BonificaKms) v.clone())
                .collect(Collectors.toList());
    }
}
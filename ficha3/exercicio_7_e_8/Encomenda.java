
public class Encomenda {
    private String nomeCliente;
    private int nif;
    private String morada;
    private int numeroEncomenda;
    private LocalDate data;
    private ArrayList<LinhaEncomenda> encomendas;

    /**
     * Construtor de acesso a Encomenda dando todos os parametros
     * @param nomeCliente Nome do cliente
     * @param nif Numero de identificaçao fiscal do cliente
     * @param morada Morada do cliente
     * @param numeroEncomenda Numero da encomenda do cliente
     * @param data Data de entrega da encomenda
     * @param encomendas Linhas da encomenda
     */
    public Encomenda (String nomeCliente, int nif, String morada, int numeroEncomenda, LocalDate data, ArrayList<LinhaEncomenda> encomendas ){
        this.nomeCliente = nomeCliente;
        this.nif = nif;
        this.morada = morada;
        this.numeroEncomenda = numeroEncomenda;
        this.data = data;
        this.setEncomendas(encomendas);
    }

    /**
     * Construtor de acesso a Encomenda
     */
    public Encomenda (){
        this.nomeCliente = null;
        this.nif = 0;
        this.morada = null;
        this.numeroEncomenda = 0;
        this.data = LocalDate.now();
        this.encomendas = new ArrayList<LinhaEncomenda>(encomendas.size());
    }

    /**
     * Construtor de acesso a Encomenda dando uma outra Encomenda
     * @param ec Encomenda
     */
    public Encomenda (Encomenda ec){
        this.nomeCliente = ec.getNomeCliente();
        this.nif = ec.getNif();
        this.morada = ec.getMorada();
        this.numeroEncomenda = ec.getNumeroEncomenda();
        this.data = ec.getData();
        this.setEncomendas(ec.getEncomendas());
    }

    /**
     * Getter do nome do cliente
     * @return Nome do cliente
     */
    public String getNomeCliente() {
        return this.nomeCliente;
    }
    
    /**
     * Setter do nome do cliente
     * @param nomeCliente Nome do cliente 
     */
    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    /**
     * Getter do NIF
     * @return NIF
     */
    public int getNif() {
        return this.nif;
    }

    /**
     * Setter do NIF
     * @param nif NIF
     */
    public void setNif(int nif) {
        this.nif = nif;
    }

    /**
     * Getter da morada
     * @return Morada
     */
    public String getMorada() {
        return this.morada;
    }

    /**
     * Setter da morada
     * @param morada Morada
     */
    public void setMorada(String morada) {
        this.morada = morada;
    }

    /**
     * Getter do numero da encomenda
     * @return Numero da encomenda
     */
    public int getNumeroEncomenda() {
        return this.numeroEncomenda;
    }

    /**
     * Setter do numero de encomenda
     * @param numeroEncomenda Numero da encomenda
     */
    public void setNumeroEncomenda(int numeroEncomenda) {
        this.numeroEncomenda = numeroEncomenda;
    }

    /**
     * Getter da data
     * @return Data
     */
    public LocalDate getData() {
        return this.data;
    }

    /**
     * Setter da data
     * @param data Data
     */
    public void setData(LocalDate data) {
        this.data = data;
    }

    /**
     * Getter das Encomendas
     * @return Encomendas
     */
    public ArrayList<LinhaEncomenda> getEncomendas() {
        return this.encomendas;
    }

    /**
     * Setter das Encomendas
     * @param encomendas Encomendas
     */
    public void setEncomendas(ArrayList<LinhaEncomenda> encomendas) {
        this.encomendas = new ArrayList<>();
        for(LinhaEncomenda le : encomendas) {
            this.encomendas.add(le.clone());
        }
    }

    /**
     * Transforma uma encomenda numa string
     */
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Nome de cliente = '").append(this.nomeCliente).append("'| ");
        sb.append("NIF = ").append(this.nif).append("| ");
        sb.append("Morada = '").append(this.morada).append("'| ");
        sb.append("Número de encomenda = ").append(this.numeroEncomenda).append("| ");
        sb.append("Data = ").append(this.data.toString()).append("\n ");
        sb.append("\nDetalhes da encomenda = ").append(this.encomendas.toString()).append(" ");
        sb.append('\n');
        return sb.toString();
    }

    /**
     * Verifica se 2 objetos sao iguais (neste caso, verifica se 2 objetos do tipo EncEficiente sao iguais)
     */
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || this.getClass() != o.getClass())
            return false;
        EncEficiente ec = (EncEficiente) o;
        return this.nomeCliente     == ec.nomeCliente     &&
               this.nif             == ec.nif             &&
               this.morada          == ec.morada          &&
               this.numeroEncomenda == ec.numeroEncomenda &&
               this.data            == ec.data            &&
               this.encomendas.equals(ec.encomendas);
    }

    /**
     * Clone de uma Encomenda
     */
    public Encomenda clone() {
        return new Encomenda(this);
    }

    /**
     * Calcula o valor total da encomenda
     * @return Valor total da encomenda
     */
    public double calculaValorTotal(){
        double vt = 0.0;
        for (LinhaEncomenda le : this.encomendas)
            vt += le.calculaValorLinhaEnc();
        return vt;
    }

    /**
     * Calcula o valor total dos descontos obtidos nos diversos produtos encomendados
     * @return Valor total dos descontos
     */
    public double calculaValorDesconto(){
        double vc = 0.0;
        for (LinhaEncomenda le: this.encomendas)
            vc += le.calculaValorDesconto();
        return vc;
    }

    /**
     * Determina o numero total de produtos a receber
     * @return Numero total de produtos a receber
     */
    public int numeroTotalProdutos(){
        int ntp = 0;
        for(LinhaEncomenda le: this.encomendas)
            ntp += le.getQuantidade();
        return ntp;
    }

    /**
     * Verifica se um produto vai ser encomendado
     * @param refProduto Referencia do produto a verificar
     * @return true se vai ser encomendadoo, false caso contrário
     */
    public boolean existeProdutoEncomenda(String refProduto){
        boolean res = false;
        for (LinhaEncomenda le: this.encomendas)
            if (refProduto.equals(le.getReferencia()))
                res = true;
        return res;
    }

    /**
     * Adiciona mais uma linha de encomenda ao array de linhas de encomenda
     * @param linha Nova linha a adicionar
     */
    public void adicionaLinha(LinhaEncomenda linha){
        this.encomendas.add(linha);
    }

    /**
     * Remove uma linha de encomenda dado a referencia do produto
     * @param codProd Referencia do produto a eliminar
     */
    public void removeProduto(String codProd){
        for (LinhaEncomenda le: this.encomendas){
            if (codProd.equals(le.getReferencia()))
                this.encomendas.remove(le);
        }
    }

}

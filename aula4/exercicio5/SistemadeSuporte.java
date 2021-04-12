import java.time.*;
import java.util.ArrayList;
import java.util.List;


import java.time.temporal.ChronoUnit;

public class SistemadeSuporte {
    private List<PedidodeSuporte> pedidos;

    public SistemadeSuporte (List<PedidodeSuporte> pedidos){
        this.setPedidos(pedidos);
    }

    public SistemadeSuporte (){
        this.pedidos = new ArrayList<>();
    }

    public SistemadeSuporte (SistemadeSuporte ss){
        this.pedidos =  ss.getPedidos();
    }

    public List<PedidodeSuporte> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<PedidodeSuporte> pedidos) {
        this.pedidos = pedidos;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Sistema de pedidos: ").append(pedidos).append("\n");
        return sb.toString();
    }

    public boolean equals(Object o) {
        if (o == this)
            return true;
        else if (o == null || o.getClass() != this.getClass())
            return false;
        SistemadeSuporte s = (SistemadeSuporte) o;
        return (this.pedidos.equals(s.getPedidos()));
    }

    public SistemadeSuporte clone() {
        return new SistemadeSuporte(this);
    }

    /**
     * Insere um pedido no sistema de pedidos
     * @param pedido Pedido a inserir
     */
    public void inserePedido(PedidodeSuporte pedido){
        pedido.setDataTratamento(LocalDateTime.now());
        this.pedidos.add(pedido);
    }

    /**
     * Devolve o pedido, dando como argumentos o nome do utilizador e a data do pedido
     * @param user Utilizador
     * @param data Data
     * @return Pedido do utilizador numa certa data
     */
    public PedidodeSuporte procuraPedido(String user, LocalDateTime data){
        for (PedidodeSuporte ps : this.pedidos)
            if (ps.getUtilizador().equals(user) && ps.getData().equals(data))
                return ps.clone();
        return null;
    }

    /**
     * Devolve o indice do pedido no sistema de pedidos, dando como argumentos o nome do utilizador e a data do pedido
     * @param user Utilizador
     * @param data Data
     * @return indice do dedido do utilizador numa certa data no sistema de pedidos
     */
    public int procuraPedidoIndice(String user, LocalDateTime data) {
        int i = 0;
        for (PedidodeSuporte ps : this.pedidos){
            if (ps.getUtilizador().equals(user) && ps.getData().equals(data))
                return i;
            i++;    
        }
            
        return -1;
    }

    /**
     * Resolve um pedido de suporte indicando o técnico e a informação relacionada com o pedido. 
     * Este método é responsável por preencher a informação da data/hora de resolução do pedido
     * 
     * @param p pedido a resolver
     * @param tecnico tecnico que vai resolver o pedido
     * @param info descriçao do tratamento
     */
    public void resolvePedido(PedidodeSuporte p, String tecnico, String info){
        p.setOperadorSolucao(tecnico);
        p.setData(LocalDateTime.now());
        p.setDescricaoTratamento(info);

        int i = procuraPedidoIndice(p.getUtilizador(), p.getData());

        pedidos.set(i, p);
    }

    /**
     * Calcula a lista dos problemas resolvidos, i.e. devolve apenas os pedidos com nome do tecnico
     * @return Lista dos problemas resolvidos
     */
    public List<PedidodeSuporte> resolvidos(){
        List<PedidodeSuporte> res = new ArrayList<>();
        for (PedidodeSuporte ps : this.pedidos)
            if (!(ps.getOperadorSolucao().equals("")))
                res.add(ps);
        return res;
    }


    /**
     * Calcula quantos problemas foram resolvidos por um dado empregado
     * @param empregado Nome do empregado
     * @return problemas resolvidos pelo empregado
     */
    public int problemasResolvidos(String empregado) {
        int res = 0;
        for (PedidodeSuporte ps : this.pedidos)
            if (ps.getOperadorSolucao().equals(empregado))
                res++;
        return res;
    }

    /**
     * Calcula o empregado com mais problemas resolvidos
     * @return Empregado com mais problemas resolvidos
     */
    public String colaboradorTop(){
        ArrayList<PedidodeSuporte> copy = new ArrayList<PedidodeSuporte>(this.pedidos);
        String top = null;
        for (PedidodeSuporte ps : copy)
            if (top == null || problemasResolvidos(ps.getOperadorSolucao()) > problemasResolvidos(top))
                top = ps.getOperadorSolucao();
        return top;
    }

    /**
     * Devolve a lista dos pedidos resolvidos num intervalo de tempo
     * @param inicio Instante inicial
     * @param fim Instante final
     * @return Lista de pedidos resolvidos num intervalo de tempo
     */
    public List<PedidodeSuporte> resolvidos(LocalDateTime inicio, LocalDateTime fim){
        List<PedidodeSuporte> sol = this.resolvidos();
        List<PedidodeSuporte> res = new ArrayList<>();
        for (PedidodeSuporte ps : sol) {
            if (ps.getDataTratamento().compareTo(inicio) >= 0 && ps.getDataTratamento().compareTo(fim) < 0)
                res.add(ps);
        }
        return res;
    }

    /**
     * Calcula a diferença em minutos entre 2 datas
     * @param begin Data inicial
     * @param end Data final
     * @return Diferença das datas em minutos
     */
    public int diffDatas(LocalDateTime begin, LocalDateTime end) {
        return (int) ChronoUnit.MINUTES.between(begin, end);
    }

    /**
     * Calcula o tempo medio de resoluçao de problemas
     * @return tempo medio de resoluçao
     */
    public double tempoMedioResolucao(){
        List<PedidodeSuporte> res = resolvidos();
        int probResol = 0;
        int totalTime = 0;
        for (PedidodeSuporte ps : res) {
            totalTime += diffDatas(ps.getData(), ps.getDataTratamento());
            probResol++;
        }
        return (double) totalTime / probResol;
    }

    /**
     * Calcula o tempo medio de resoluçao de problemas num intervalo de tempo
     * @param inicio instante inicial
     * @param fim instante final
     * @return tempo medio de resoluçao
     */
    public double tempoMedioResolucao(LocalDateTime inicio, LocalDateTime fim){
        List<PedidodeSuporte> res = resolvidos(inicio, fim);
        int probResol = 0;
        int totalTime = 0;
        for (PedidodeSuporte ps : res) {
            totalTime += diffDatas(ps.getData(), ps.getDataTratamento());
            probResol++;
        }
        return (double) totalTime / probResol;
    }

    public static void main(String[] args) {
        LocalDateTime dt1 = LocalDateTime.of(2020, Month.DECEMBER, 25, 12, 30);
        LocalDateTime dt2 = LocalDateTime.of(1999, Month.MARCH, 3, 11, 20);
        LocalDateTime dt3 = LocalDateTime.of(2020, Month.DECEMBER, 2, 2, 3);

        PedidodeSuporte sr = new PedidodeSuporte("Jorge", dt1, "Máquina de lavar", "Deita água desnecessaria");
        PedidodeSuporte sr2 = new PedidodeSuporte("Marcio", dt2, "Frigorifico", "Nao arrefece");
        PedidodeSuporte sr3 = new PedidodeSuporte("Anacleto", dt3, "Computador", "Muito lento");
        SistemadeSuporte ss = new SistemadeSuporte();

        System.out.println("Inserindo 3 pedidos...");
        System.out.println("");
        ss.inserePedido(sr);
        ss.inserePedido(sr2);
        ss.inserePedido(sr3);
        
        System.out.println(ss.toString());

        ss.resolvePedido(sr, "Manel", "Antes água que vinho!");
        System.out.println("Manel é chamado ao trabalho...");
        System.out.println("");
        
        System.out.println(ss.toString());
        
        ss.resolvePedido(sr2, "Jesualdo", "Tem que ser ainda mais quente");
        System.out.println("Jesualdo é chamado ao trabalho...");
        System.out.println("");

        System.out.println(ss.resolvidos());
        System.out.println("");

        ss.resolvePedido(sr3, "Quim", "Atira-o ao chao");
        System.out.println("Quim é chamado ao trabalho...");
        System.out.println("");
        System.out.println(ss.toString());
        
        
        System.out.println("");
        System.out.println(ss.colaboradorTop());
        /*
        
        System.out.println("");
        System.out.println(ss.tempoMedioResolucao()); */
    }
}

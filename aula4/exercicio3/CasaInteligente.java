import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CasaInteligente {
    ArrayList<Lampada> lamps;

    public CasaInteligente(ArrayList<Lampada> lamps) {
        this.setLamps(lamps);
    }

    public CasaInteligente(CasaInteligente s) {
        this.setLamps(s.getLamps());
    }

    public CasaInteligente() {
        this.lamps = new ArrayList<Lampada>();
    }

    /**
     * Casa inteligente para string
     */
    public String toString() {
        return this.lamps.toString();
    }

    /**
     * Metodo equals
     */
    public boolean equals(Object o) {
        if (o == this)
            return true;
        else if (o == null || this.getClass() != o.getClass())
            return false;
        CasaInteligente c = (CasaInteligente) o;
        return (this.lamps.equals(c.getLamps()));
    }

    /**
     * Getter da CasaInteligente
     * @return ArrayList de lampadas
     */
    public ArrayList<Lampada> getLamps() {
        return this.lamps;
    }

    /**
     * Setter da CasaInteligente
     * 
     * Adiciona as lampadas num outro objeto Arraylist
     * 
     * @param lamps ArrayList de lampadas
     */
    public void setLamps(ArrayList<Lampada> lamps) {
        this.lamps = lamps;
    }

    /**
     * Adiciona uma lampada ao conjunto de lampadas da casa inteligente
     * @param l Lampada a inserir
     */
    public void addLampada(Lampada l) {
        this.lamps.add(l);
    }

    /**
     * Liga a lampada que está no indice index
     * @param index Indice da lampada a alterar
     */
    public void ligaLampadaNormal(int index) {
        this.lamps.get(index).setModo("Ligado");
    }

    /**
     * Coloca a lampada em modo ECO que está no indice index
     * @param index Indice da lampada a alterar
     */
    public void ligaLampadaEco(int index) {
        this.lamps.get(index).setModo("Eco");
    }

    /**
     * Devolve o numero de lampadas em modo ECO
     * 
     * stream().filter(l -> l.getModo().equals("Eco"))         : filtra         todas as lampadas cujo modo é ECO 
     * stream().filter(l -> l.getModo().equals("Eco")).count() : filtra e conta todas as lampadas cujo modo é ECO 
     * 
     * @return Numero de lampadas em modo ECO
     */
    public int qtEmEco() {
        return (int) this.lamps.stream().filter(l -> l.getModo().equals("Eco")).count();
    }

    /**
     * Remove uma lampada no indice index
     * @param index Indice onde se irá remover a lampada
     */
    public void removeLampada(int index) {
        this.lamps.remove(index);
    }

    /**
     * Liga todas a lampadas em modo ECO
     */
    public void ligaTodasEco() {
        this.lamps.forEach(Lampada::lampECO);
    }

    /**
     * Liga todas as lampadas 
     */
    public void ligaTodasMax() {
        this.lamps.forEach(Lampada::lampON);
    }

    /**
     * Devolve o consumo das lampadas da casa
     * @return Consumo total das lampadas da casa
     */
    public double consumoTotal() {
        double res = 0;
        for (Lampada l : this.lamps)
            res += l.getConsumido();
        return res;
    }

    /**
     * Efectua o reset do contador parcial de consumo em todas as lâmpadas
     */
    public void reset() {
        this.lamps.forEach(Lampada::resetConsumo);
    }

    public static void main(String[] args) {
        Lampada lam = new Lampada();
        Lampada lam2 = lam.clone();
        Lampada lam3 = lam.clone();

        ArrayList<Lampada> listaLampadas = new ArrayList<Lampada>();
        listaLampadas.add(lam);
        listaLampadas.add(lam2);

        CasaInteligente c = new CasaInteligente(listaLampadas);
        System.out.println("Adicionando 2 lampadas...");
        System.out.println(c.toString());
        System.out.println("");

        c.addLampada(lam3);
        System.out.println("Adicionado a lampada nº3...");
        c.ligaTodasEco();
        System.out.println("Ligando todas as lampadas em modo ECO..");
        System.out.println(c.toString());
        System.out.println("");

        System.out.println("Ligando a lampada 3 para o modo normal...");
        c.ligaLampadaNormal(2);
        System.out.println("Removendo a lampada 2...");
        c.removeLampada(1);
        System.out.println(c.toString());
        System.out.println("");

        c.ligaTodasMax();
        System.out.println("Ligando todas as lampadas no modo normal...");
        System.out.println(c.toString());
        System.out.println("");

        System.out.println("Existem " + c.qtEmEco()+" lampadas em modo ECO na casa");
        System.out.println("O consumo total de todas as lampadas da casa foi de "+c.consumoTotal());

        c.reset();
        System.out.println("");
        System.out.println("Efetuando reset ao consumo de todas as lampadas...");
        System.out.println(c.toString());
    }

}
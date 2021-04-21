public class Lampada {
    private String modo;
    private double consumido;
    private double tempoConsumo;
    private double inicioConsumo;
    private double consumoPorMs;

    public Lampada (String modo, double consumido, double tempoConsumo){
        this.modo = modo;
        this.consumido = consumido;
        this.tempoConsumo = tempoConsumo;
        this.inicioConsumo = System.nanoTime();
        this.consumoPorMs = consumoPorMs;
    }

    public Lampada (){
        this.modo = "Desligado";
        this.inicioConsumo = System.nanoTime();
        this.tempoConsumo = 0.0;
        this.consumido = 0.0;
        this.consumoPorMs = 0.0;
    }

    public Lampada (Lampada l){
        this.modo = l.getModo();
        this.inicioConsumo = l.getInicioConsumo();
        this.consumoPorMs = l.getConsumoPorMs();
        this.consumido = l.getConsumido();
        this.tempoConsumo = l.getTempoConsumo();
    }

   
    public String getModo(){
        return modo; 
    }

    public double getInicioConsumo() {
        return inicioConsumo;
    }
    
    public double getConsumoPorMs() {
        return consumoPorMs;
    }
    
    public double getConsumido() {
        return consumido;
    }

    public double getTempoConsumo() {
        return tempoConsumo;
    }

    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (o == null || this.getClass() != o.getClass())
            return false;
        Lampada l = (Lampada) o;
        return (this.tempoConsumo == l.getTempoConsumo() 
               && this.consumido == l.getConsumido()
               && this.consumoPorMs == l.getConsumoPorMs() 
               && this.modo == l.getModo() 
               && this.inicioConsumo == l.getInicioConsumo());
    }

    public String toString() {
        final StringBuilder sb = new StringBuilder("Lampada: {");
        sb.append("Modo: ").append(modo);
        sb.append(", Consumo desde o ultimo uso: ").append(tempoConsumo);
        sb.append(", Total consumo: ").append(consumido);
        sb.append(", Consumo por milissegundo: ").append(consumoPorMs);
        sb.append("}");
        return (sb.toString());
    }

    public void lampON() {
        atualizaConsumo();
        this.inicioConsumo = System.nanoTime();
        this.modo = "Ligado";
        this.consumoPorMs = 2;
    }

    public void lampOFF() {
        atualizaConsumo();
        this.inicioConsumo = System.nanoTime();
        this.modo = "Desligado";
        this.consumoPorMs = 0;
    }

    public void lampECO() {
        atualizaConsumo();
        this.inicioConsumo = System.nanoTime();
        this.modo = "Eco";
        this.consumoPorMs = 1;
    }

    public void atualizaConsumo() {
        this.tempoConsumo += ((System.nanoTime() - this.inicioConsumo) / 1000 * this.consumoPorMs);
        this.consumido    += ((System.nanoTime() - this.inicioConsumo) / 1000 * this.consumoPorMs);
    }

    public void resetConsumo() {
        this.tempoConsumo = 0;
    }

    public static void main(String[] args) {
        System.out.println("Lampada 1:");
        Lampada lamp1 = new Lampada();
        System.out.println(lamp1.toString());

        System.out.println("");
        System.out.println("Ligar a lampada 1:");
        lamp1.lampON();
        System.out.println(lamp1.toString());
        System.out.println("");

        System.out.println("Lampada 2:");
        Lampada lamp2 = new Lampada(lamp1);
        System.out.println(lamp2);
        System.out.println("");

        System.out.println("Ver o consumo da lampada1:");
        lamp1.atualizaConsumo();
        System.out.println(lamp1.toString());
        
        System.out.println("");
        System.out.println("Dar reset ao consumo da lampada 1");
        lamp1.resetConsumo();
        System.out.println("Tempo de consumo da lampada 1: "+lamp1.tempoConsumo);
        
        System.out.println("");
        System.out.println("Lampada em modo ECO:");
        lamp1.lampECO();
        lamp1.atualizaConsumo();
        
        System.out.println(lamp1.toString());
        
        System.out.println("");
        System.out.println("Desligar a lampada");
        lamp1.lampOFF();
        System.out.println(lamp1.toString());
    }

}



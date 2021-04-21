public class Carro {
    private String estado;
    private String marca;
    private String modelo;
    private int ano;
    private long consumoKm;
    private double kmsDesdeInicio;
    private long mediaConsumoDesdeInicio;
    private double kmsUltimoPercurso;
    private long mediaConsumoUltimoPercurso;
    private int capacidadeReg;

    public Carro (String marca, String modelo, int ano, long consumoKm, int capacidadeReg){
        this.estado = "Desligado";
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.consumoKm = consumoKm;
        this.capacidadeReg = capacidadeReg;
        this.kmsDesdeInicio = (double) 0;
        this.mediaConsumoDesdeInicio = (long) 0;
        this.kmsUltimoPercurso = (double) 0;
        this.mediaConsumoUltimoPercurso = (long) 0;
    }

    public Carro (String marca, String modelo, int ano, long consumoKm, 
                  double kmsDesdeInicio, long mediaConsumoDesdeInicio, 
                  double kmsUltimoPercurso, long mediaConsumoUltimoPercurso, int capacidadeReg){
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.consumoKm = consumoKm;
        this.kmsDesdeInicio = kmsDesdeInicio;
        this.mediaConsumoDesdeInicio = mediaConsumoDesdeInicio;
        this.kmsUltimoPercurso = kmsUltimoPercurso;
        this.mediaConsumoUltimoPercurso = mediaConsumoUltimoPercurso;
        this.capacidadeReg = capacidadeReg; 
    }

    public Carro (Carro c){
        this.marca = c.getMarca();
        this.modelo = c.getModelo();
        this.ano = c.getAno();
        this.consumoKm = c.getConsumoKm();
        this.kmsDesdeInicio = c.getKmsDesdeInicio();
        this.mediaConsumoDesdeInicio = c.getMediaConsumoDesdeInicio();
        this.kmsUltimoPercurso = c.getKmsUltimoPercurso();
        this.mediaConsumoUltimoPercurso = c.getMediaConsumoUltimoPercurso();
        this.capacidadeReg = c.getCapacidadeReg();
    }

    public Carro clone(Carro c){
        return (new Carro(c));
    }

    public String toString() {
        final StringBuilder sb = new StringBuilder("Carro: {");
        sb.append("Estado: ").append(estado);
        sb.append(", Marca: ").append(marca);
        sb.append(", Modelo: ").append(modelo);
        sb.append(", Ano: ").append(ano);
        sb.append(", Consumo: ").append(consumoKm);
        sb.append(", TotalKm: ").append(kmsDesdeInicio);
        sb.append(", Média do consumo: ").append(mediaConsumoDesdeInicio);
        sb.append(", Km na ultima viagem: ").append(kmsUltimoPercurso);
        sb.append(", Consumo medio na ultima viagem: ").append(mediaConsumoUltimoPercurso);
        sb.append(", Capacidade de regeneraçao de energia: ").append(capacidadeReg);
        sb.append("}");
        return sb.toString();
    }

    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || this.getClass() != o.getClass())
            return false;
        Carro c = (Carro) o;
        return (this.estado == c.getEstado()                                            && this.marca == c.getMarca() 
                && this.modelo == c.getModelo()                                         && this.ano == c.getAno() 
                && this.consumoKm == c.getConsumoKm()                                   && this.kmsDesdeInicio == c.getKmsDesdeInicio()
                && this.mediaConsumoDesdeInicio == c.getMediaConsumoDesdeInicio()       && this.kmsUltimoPercurso == c.getKmsUltimoPercurso()
                && this.mediaConsumoUltimoPercurso == c.getMediaConsumoUltimoPercurso() && this.capacidadeReg == c.getCapacidadeReg());
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public long getConsumoKm() {
        return consumoKm;
    }

    public void setConsumoKm(long consumoKm) {
        this.consumoKm = consumoKm;
    }

    public double getKmsDesdeInicio() {
        return kmsDesdeInicio;
    }

    public void setKmsDesdeInicio(double kmsDesdeInicio) {
        this.kmsDesdeInicio = kmsDesdeInicio;
    }

    public double getKmsUltimoPercurso() {
        return kmsUltimoPercurso;
    }

    public void setKmsUltimoPercurso(double kmsUltimoPercurso) {
        this.kmsUltimoPercurso = kmsUltimoPercurso;
    }

    public long getMediaConsumoDesdeInicio() {
        return mediaConsumoDesdeInicio;
    }

    public void setMediaConsumoDesdeInicio(long mediaConsumoDesdeInicio) {
        this.mediaConsumoDesdeInicio = mediaConsumoDesdeInicio;
    }

    public long getMediaConsumoUltimoPercurso() {
        return mediaConsumoUltimoPercurso;
    }

    public void setMediaConsumoUltimoPercurso(long mediaConsumoUltimoPercurso) {
        this.mediaConsumoUltimoPercurso = mediaConsumoUltimoPercurso;
    }

    public int getCapacidadeReg() {
        return capacidadeReg;
    }

    public void setCapacidadeReg(int capacidadeReg) {
        this.capacidadeReg = capacidadeReg;
    }
    
    /**
     * Liga o carro
     */
    public void ligaCarro(){
        this.estado = "Ligado";
        resetUltimaViagem();
    }

    /**
     * Desliga o carro
     */
    public void desligaCarro(){
        this.estado = "Desligado";
    }

    /**
     * Reset aos dados da ultima viagem efetuada
     */
    public void resetUltimaViagem(){
        this.kmsUltimoPercurso = 0;
        this.mediaConsumoUltimoPercurso = 0;
    }

    /**
     * Aumento à kilometragem total, kilometragem do ultimo percurso, media de consumo total e media do consumo da ultima viagem
     * @param metros Metros percorridos pelo carro
     * @param velocidade Velocidade do carro
     */
    public void avancaCarro(double metros, double velocidade){
        if (this.estado == "Ligado") {
            double km = metros / 1000;
            double consumo = km * ((velocidade * this.consumoKm) / 100);

            this.kmsUltimoPercurso += km;
            this.kmsDesdeInicio += km;
            this.mediaConsumoDesdeInicio    += consumo / km;
            this.mediaConsumoUltimoPercurso += consumo / km;
        }
    }

    /**
     * Diminuição à kilometragem total, kilometragem do ultimo percurso, media de consumo total e media do consumo da ultima viagem
     * @param metros Distancia percorrida pelo carro para travar
     */
    public void travaCarro(double metros) {
        if (this.estado == "Desligado") {
            double km = metros / 1000;
            double reg = this.capacidadeReg * km;
            
            this.kmsUltimoPercurso += km;
            this.mediaConsumoUltimoPercurso = (long) (reg / km);

            this.kmsDesdeInicio += km;
            this.mediaConsumoDesdeInicio -= (reg / km);
        }
    }

    public static void main(String[] args) {
        System.out.println("Carro 1:");
        Carro c1 = new Carro("Lamborghini", "Murcielago", 2011, 4, 1);
        System.out.println(c1.toString());
        c1.ligaCarro();
        c1.avancaCarro(1000000, 200);
        System.out.println(c1.toString());
        System.out.println("");

        Carro c2 = new Carro(c1);
        System.out.println("Carro 2:");
        System.out.println(c2);
        System.out.println("");

        System.out.print("O carro 1 é igual ao carro 2? ");
        System.out.println(c2.equals(c1));
        c2.travaCarro(2000);
        System.out.println("");
        
        System.out.println(c2);
        System.out.println("");
        
        System.out.print("O carro 1 é igual ao carro 2? ");
        System.out.println(c2.equals(c1));
        c1.resetUltimaViagem();
        System.out.println("");
        
        System.out.println(c1);
        c1.avancaCarro(1000, 3);
        System.out.println("");
        
        System.out.println(c1);
    }
}
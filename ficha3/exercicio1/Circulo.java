

public class Circulo {
    private double x;
    private double y;
    private double raio;

    /**
     * Construtor para objetos de classe Circulo
     */
    public Circulo(){
        this.x = this.y = 0;
        this.raio = 1;
    }

    public Circulo (double x, double y, double raio){
        this.x = x;
        this.y = y;
        this.raio = raio;
    }

    public Circulo (Circulo c){
        this.x = c.getX();
        this.y = c.getY();
        this.raio = c.getRaio();
    }

    /**
     * Calcula a abcissa
     * @return Variavel x
     */
    public double getX(){
        return this.x;
    }

    /**
     * Calcula a ordenada
     * @return Variavel y
     */
    public double getY(){
        return this.y;
    }

    /**
     * Calcula o raio
     * @return Variavel raio
     */
    public double getRaio(){
        return this.raio;
    }

    /**
     * Atualiza a abcissa
     * @param x Valor x a inserir
     */
    public void setX (double x){
        this.x = x;
    }

    /**
     * Atualiza a ordenada
     * @param y Valor y a inserir
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     * Atualiza o raio
     * @param raio Valor raio a inserir
     */
    public void setRaio(double raio) {
        this.raio = raio;
    }

    /**
     * Atualiza o centro do circulo
     * @param x Abcissa a inserir
     * @param y Ordenada a inserir
     */
    public void alteraCentro(double x, double y){
        this.x = x;
        this.y = y;
    }

    /**
     * Calcula a area do circulo
     * @return Area do circulo
     */
    public double calculaArea(){
        return Math.PI * this.raio * this.raio;
    }

    /**
     * Calcula o perimetro do circulo
     * @return Perimetro do circulo
     */
    public double calculaPerimetro(){
        return 2 * Math.PI * this.raio;
    }

    /**
     * Escreve uma string com os dados de um circulo
     * @return String circulo
     */
    public String circuloParaString(){
        return("Circulo: (x: " + this.x + ", y: " + this.y + ", raio: "+this.raio+")");
    }

    /**
     * Cria um novo circulo (metodo clone)
     */
    public Circulo clonar(){
        return new Circulo(this);
    }

    /**
     * Verifica se 2 objetos sao iguais (metodo equals)
     * @param o Objeto generico
     * @return true se são iguais, false caso contrário
     */
    public boolean iguais (Object o){
        if (this == 0)
            return true;
        if ((o == null)||(o.getClass()!=this.getClass()))
            return false;
        Circulo c = (Circulo) o;
        return this.x == c.getX() && this.y == c.getY() && this.raio == c.getRaio();
    }

    public static void main(String[] args) {
        Circulo c1,c2,c3;
        c1 = new Circulo();
        c2 = new Circulo(10,5,20);
        c3 = new Circulo (c2);

        System.out.println("Área de c1 -> " +c1.calculaArea());
        System.out.println("Abcissa de c3 -> " + c3.getX());
        c3.alteraCentro(2,5);
        System.out.println("Abcissa de c3 (atualizado) -> " + c3.getX());
        System.out.println("Abcissa de c2 -> " + c2.getX());
    }
}

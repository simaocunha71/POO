public class Triangulo {
    private Ponto p1,p2,p3;

    public Triangulo (Ponto p1, Ponto p2, Ponto p3){
        this.p1 = p1.clone();
        this.p2 = p2.clone();
        this.p3 = p3.clone();
    }

    public Triangulo (){
        this.p1 = new Ponto();
        this.p2 = new Ponto();
        this.p3 = new Ponto();
    }

    public Triangulo (Triangulo t){
        this.p1 = t.getP1();
        this.p2 = t.getP2();
        this.p3 = t.getP3();
    }

    public Ponto getP1() {
        return this.p1.clone();
    }

    public Ponto getP2() {
        return this.p2.clone();
    }

    public Ponto getP3() {
        return this.p3.clone();
    }

    public void setP1(Ponto p1) {
        this.p1 = p1.clone();
    }

    public void setP2(Ponto p2) {
        this.p2 = p2.clone();
    }

    public void setP3(Ponto p3) {
        this.p3 = p3.clone();
    }

    public String toString() {
        return "Triangulo: " + this.p1.toString() + "/"
                             + this.p2.toString() + "/"
                             + this.p3.toString();
    }

    public boolean equals (Object o){
        if (o == this)
            return true;
        if (o==null || o.getClass() != this.getClass())
            return false;
        Triangulo t = (Triangulo) o;
        return this.p1.equals(t.getP1()) &&
               this.p2.equals(t.getP2()) &&
               this.p3.equals(t.getP3());
    }

    public Triangulo clone(){
        return new Triangulo(this);
    }

    public double calculaAreaTriangulo(){
        double dis1 = p1.distancia(p2);
        double dis2 = p2.distancia(p3);
        double dis3 = p3.distancia(p1);

        double temp = (dis1 + dis2 + dis3) / 2;
        
        return Math.sqrt(temp * (temp - dis1) * (temp - dis2) * (temp - dis3));
    }

    public double calculaPerimetroTriangulo() {
        return this.p1.distancia(this.p2) + this.p2.distancia(this.p3) + this.p3.distancia(this.p1);
    }

    public double altura(){
        double minY = Double.POSITIVE_INFINITY; 
        double maxY = Double.NEGATIVE_INFINITY;
        double[] ordenadas = { p1.getY(), p2.getY(), p3.getY() };
        for (double y : ordenadas) {
            if (y < minY)
                minY = y;
            if (y > maxY)
                maxY = y;
        }
        return maxY - minY;
    }

    public static void main(String[] args) {
        Ponto p1 = new Ponto(2, 5);
        Ponto p2 = new Ponto(-1, 9);
        Ponto p3 = new Ponto(0, -9);
        
        Triangulo t1 = new Triangulo();
        System.out.println(t1.toString());
        
        Triangulo t2 = new Triangulo(p1, p2, p3);
        System.out.println(t2.toString());
        System.out.println(t1.equals(t2));

        Triangulo t3 = new Triangulo(t2);
        System.out.println("T2 é igual a T3? "+t2.equals(t3));
        System.out.println("Area de t2: " + t2.calculaAreaTriangulo());
        System.out.println("Perimetro de t2: " + t2.calculaPerimetroTriangulo());
        System.out.println("Altura do triangulo t2: " + t2.altura());
    }
}

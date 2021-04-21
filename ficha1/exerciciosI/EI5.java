import java.util.Scanner;

public class EI5 {
    /**
     * Calcula o perimetro de um triangulo
     * @param base base do triangulo
     * @param altura altura do triangulo
     */
    public static void perimetro(double base, double altura) {
        double hipot = Math.sqrt((base * base) + (altura * altura)); //hipotenusa
        double perimetro = base + altura + hipot;
        perimetro = (double) Math.round(perimetro * 100000d) / 100000d;
        System.out.println("Perimetro: " + perimetro);
    }

    /**
     * Calcula a área de um triângulo
     * @param base base do triangulo
     * @param altura altura do triangulo
     */
    public static void area(double base, double altura) {
        double area = (base * altura) / 2;
        area = (double) Math.round(area * 100000d) / 100000d;
        System.out.println("Area: " + area);
    }

    public static void main(String[] args) {
        Scanner tri = new Scanner(System.in);
            System.out.println("Escreve a base e a altura do triângulo: ");
            double base = tri.nextDouble();
            double altura = tri.nextDouble();
            if (base > 0 && altura > 0) {
                perimetro(base, altura);
                area(base, altura);
            } 
            else 
                System.out.println (" Tanto a base como a altura do triangulo têm de ser positivas.");
    }
}
import java.util.Scanner;
import java.util.Date;

public class EII {
    public static void I() {
        Scanner input = new Scanner(System.in);
        System.out.println("Insere uma temperatura em graus Celsius: ");
        double c = input.nextDouble();
        double f = Auxiliares.celsiusParaFarenheit(c);
        System.out.println("A temperatura em Farenheit é " + f + " F. ");
        input.close();
    }

    public static void II() {
        Scanner input = new Scanner(System.in);
        System.out.println("Insere 2 numeros: ");
        int n1 = input.nextInt();
        int n2 = input.nextInt();
        int res = Auxiliares.max(n1, n2);
        System.out.println("O maior numero dos inseridos é: " + res);
        input.close();
    }

    public static void III() {
        Scanner input = new Scanner(System.in);
        System.out.println("Escreve o teu nome de utilizador: ");
        String nome = input.nextLine();
        System.out.println("Escreve o teu saldo: ");
        int saldo = input.nextInt();
        String res = Auxiliares.criaDescricaoConta(nome, saldo);
        System.out.println(res);
        input.close();
    }

    public static void IV() {
        Scanner input = new Scanner(System.in);
        System.out.println("Insere um valor em Euros: ");
        double euro = input.nextDouble();
        System.out.println("Insere uma taxa de conversão: ");
        double taxa = input.nextDouble();
        double res = Auxiliares.convertEuros(euro, taxa);
        System.out.println("O novo valor com a taxa é: " + res);
        input.close();
    }

    public static void V() {
        Scanner input = new Scanner(System.in);
        System.out.println("Insere 2 números: ");
        int n1 = input.nextInt();
        int n2 = input.nextInt();
        String res = Auxiliares.ordDecresc(n1, n2);
        System.out.println(res);
        input.close();
    }

    public static void VI() {
        Scanner input = new Scanner(System.in);
        System.out.println("Insere um numero não negativo ");
        long n = input.nextLong();
        if (n < 0) {
            System.out.println("O numero inserido é negativo. ");
            return;
        }
        long res = Auxiliares.fact(n);
        System.out.println("O fatorial é: " + res);
        input.close();
    }

    public static void VII() {
        Date dataAtual = new Date();
        System.out.println("Data antes do cálculo do fatorial: " + dataAtual);
        long inicio = System.currentTimeMillis();
        long res = Auxiliares.fact(5000);
        long fim = System.currentTimeMillis();
        long tGasto = fim - inicio;
        System.out.println("O fatorial de 5000 é " + res + " e demorou " + tGasto + " ms para o calcular.");
    }

    public static void main(String[] args) {
        int test = Integer.parseInt(args[0]);
        switch (test) {
            case 1:
                I();
                break;
            case 2:
                II();
                break;
            case 3:
                III();
                break;
            case 4:
                IV();
                break;
            case 5:
                V();
                break;
            case 6:
                VI();
                break;
            case 7:
                VII();
                break;
            default:
                break;
        }
    }
}

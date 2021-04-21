import java.util.Scanner;

public class EI6 {
    /**
     * Testa se um numero é primo
     * @param n numero a testar
     * @return 1 se é primo, 0 caso contrário
     */
    public static int testaPrimo(int n) {
        int x = 1;
        if (n > 1) {
            for (int i = 2; i < n; i++) {
                if (n % i == 0)
                    x = 0;
            }
        }
        return x;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Escreva um número para ver todos os numeros primos antecedentes.");
        int n = input.nextInt();
        if (n != -1 && n > 1) {
            for (int i = 1; i < n; i++) 
                if (testaPrimo(i) == 1)
                    System.out.println(i);
            
        } 
        else
            System.out.println("Programa terminado. ");

        input.close();
    
    }
}
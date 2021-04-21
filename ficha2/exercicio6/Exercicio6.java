import java.util.Arrays;
import java.util.Scanner;

public class Exercicio6 {
    /**
     * Função interativa que dá uma matriz com valores introduzidos pelo utilizador
     */
    public static int[][] devolveMatriz() {
        Scanner inputReader = new Scanner(System.in);

        System.out.println("Numero de linhas da matriz?");
        int linhas = inputReader.nextInt();

        System.out.println("Numero de colunas da matriz?");
        int colunas = inputReader.nextInt();


        int[][] matriz = new int[linhas][colunas];

        System.out.println("Escreve a matriz desejada.");
        for (int i = 0; i < linhas; i++) {
            for(int j = 0; j < colunas; j++){
                matriz [i][j] = inputReader.nextInt();
            }
        }

        return matriz;
    }

    /**
     * Imprime uma matriz 
     * @param a Matriz a imprimir
     */
    public static void imprimeMatriz(int[][]a) {
        for (int[] i : a)
                System.out.println(Arrays.toString(i));      
    }

    public static int[][] somaMatrizes(int[][] a,int[][] b) {
        int[][] r = new int [a.length][b.length];
        for (int i =0; i<a.length; i++){
            for (int j = 0; j<b.length; j++){
                r[i][j] = a[i][j] + b[i][j];
            }
        }
        return r;
    }

    public static boolean matrizesIguais(int[][] a,int[][] b) {
        return Arrays.deepEquals(a,b);
    }

    public static int[][] simetrica(int[][] a) {
        int[][] r = new int [a.length][a.length];
        for (int i =0; i<a.length; i++){
            for (int j = 0; j<a.length; j++){
                r[i][j] = -1 *a[i][j];
            }
        }
        return r;
    }

    public static void e1() {
        int[][]a = devolveMatriz();
        int[][]b = devolveMatriz();

        int[][]r = somaMatrizes(a, b);
        System.out.println("Soma das matrizes inseridas:");
        imprimeMatriz(r);
    }

    public static void e2() {
        int[][] a = devolveMatriz();
        int[][] b = devolveMatriz();

        boolean eq = matrizesIguais(a, b);

        if (eq) //eq == true
            System.out.println("As matrizes são iguais.");
        else
            System.out.println("As matrizes são diferentes.");
    }

    public static void e3() {
        int[][] a = devolveMatriz();
        int[][] r = simetrica(a);
        
        System.out.println("Matriz simétrica:");
        imprimeMatriz(r);
    }

    public static void main(String[] args){
        int test = Integer.parseInt(args[0]);
        switch (test) {
            case 1:
                e1();
                break;
            case 2:
                e2();
                break;
            case 3:
                e3();
                break;
            default:
                break;
        }
    }
}
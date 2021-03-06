import java.util.Scanner;
import java.io.*;
import java.util.*;

public class Exercicio1 {

    /**
     * Função interativa que retorna um array com valores introduzidos pelo utilizador
     * @return Array
     */
    public static int[] devolveArray() {
        Scanner inputReader = new Scanner(System.in);

        System.out.println("Qual é o tamanho do array?");
        int arraySize = inputReader.nextInt();

        int[] array = new int[arraySize];

        System.out.println("Escreva o array desejado.");
        for (int i = 0; i < arraySize; i++) {
            array[i] = inputReader.nextInt();
        }

        return array;
    }

    public static void e1a() {
        int[] array = devolveArray();
        int min = AuxEx1.valorMinimo(array);
        System.out.println("O minimo é: " +min);
    }
    public static void e1b() {
        int[] array = devolveArray();

        System.out.print("Indices inicial e final: ");
        Scanner input = new Scanner(System.in);
        int indI = input.nextInt();
        int indF = input.nextInt();
        int[] res = AuxEx1.entreIndices(array, indI, indF);
        System.out.println("Sub-array: " + Arrays.toString(res)); // importante colocar o método "Arrays.toString()" para poder ver a impressão

    }

    public static void e1c () {
        int[] array1 = devolveArray();
        int[] array2 = devolveArray();  

        int[] res = AuxEx1.comuns(array1, array2);

        System.out.println("A interseção dos dois arrays é " + Arrays.toString(res));
    }
    
    public static void main(String[] args) {
        int test = Integer.parseInt(args[0]);
        switch (test) {
            case 1:
                e1a();
                break;
            case 2:
                e1b();
                break;
            case 3:
                e1c();
                break;
            default:
                break;
        }
    }
}

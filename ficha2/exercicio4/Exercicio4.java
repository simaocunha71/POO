import java.util.Arrays;
import java.util.Scanner;

public class Exercicio4 {

    /**
     * Função que devolve um array com valores introduzidos pelo utilizador
     * @return Array dado pelo utilizador
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

    /**
     * Ordena um array de forma crescente
     * @param array Array para ordenar
     * @return Array ordenado
     */
    public static void ordenaCresc(int[] array) {
        Arrays.sort(array);
    }

    /**
     * Retorna o indice de um dado elemento num array
     * @param array Array onde se vai descobrir o elemento
     * @param elem Elemento a descobrir
     * @return Indice do elemento no array
     */
    public static int procuraBinaria (int[] array, int elem){
        int r=-1;
        for (int i = 0; i < array.length; i++){
            if (array[i]==elem)
                r = i;
        }
        return r;
    }

    public static void e1() {
        int[] array = devolveArray();
        ordenaCresc(array);

        System.out.println("Array Ordenado: "+Arrays.toString(array));

    }

    public static void e2() {
        Scanner input = new Scanner(System.in);
        int[] array = devolveArray();
        System.out.println("Escreve o numero que queres procurar: ");
        int n = input.nextInt();
        int indiceFound = procuraBinaria(array, n);

        if (indiceFound != -1 )
            System.out.println("O elemento foi encontrado e encontra-se no indice "+indiceFound);
        else
            System.out.println("O elemento inserido não se encontra no array.");

    }

    public static void main(String[] args) {
        int test = Integer.parseInt(args[0]);
        switch (test) {
        case 1:
            e1();
            break;
        case 2:
            e2();
            break;
        default:
            break;
        }
    }
}

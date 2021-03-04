import java.util.Scanner;

public class Exercicio1 {
    public static void e1a() {
        Scanner input = new Scanner(System.in);
        System.out.println("Quantos números vai ler?");
        int ler = input.nextInt();
        int[] array = new int [ler];
        System.out.println("Escreve "+ ler + " números: ");
        for (int i = 0; i<ler;i++)
            array[i] = input.nextInt();
        int min = f.minimo(array);
        System.out.println("O minimo é: " +min);
    }
    public static void e1b() {
        Scanner input = new Scanner(System.in);
        System.out.print("Indices inicial e final: ");
        int indI = input.nextInt();
        int indF = input.nextInt();
        System.out.println("Sub-array: " + Auxiliares.entreIndices(array, indI, indF));

    }

    public static void e1c () {
        Scanner input = new Scanner(System.in);
        System.out.println("Tamanho dos arrays: ");

        int ler1 = input.nextInt();
        int[] array1 = new int[ler1];
        System.out.println("Insere " + ler1 + " numeros para o array 1: ");
        for (int i = 0; i < le1r; i++)
            array1[i] = input.nextInt();

        int ler2 = input.nextInt();
        int[] array2 = new int[ler1];
        System.out.println("Insere " + ler2 + " numeros para o array 2: ");
        for (int j = 0; j < ler2; j++)
            array2[j] = input.nextInt();    

        int[] res = comuns(array1, array2);

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

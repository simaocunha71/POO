import java.util.Arrays;
import java.util.Scanner;


public class Euromilhoes {
    /**
     * Imprime um array
     * @param a Array a imprimir
     */
    public static void imprimeArray(int[] a) {
        for (int i=0;i<a.length;i++)
            System.out.println(Arrays.toString(a));
    }

    /**
     * Gera um numero aleatorio entre o intervalo [min,max]
     * @param min limite inferior
     * @param max limite superior
     * @return Valor aleatorio
     */
    public static int numeroAleatorio(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    /**
     * Retorna um array com as chave introduzida pelo utilizador
     * @return Array com a chave do utilizador
     */
    public static int[] chaveUtilizador() {
        Scanner inputReader = new Scanner(System.in);
        System.out.println("Escreve 5 números para a chave: ");
        int c1 = inputReader.nextInt();
        int c2 = inputReader.nextInt();
        int c3 = inputReader.nextInt();
        int c4 = inputReader.nextInt();
        int c5 = inputReader.nextInt();

        int[]chavesU = new int [5];

        //Mete num array a chave do utilizador
        for (int i = 0; i<4;i+=4){
            chavesU[i] = c1;
            chavesU[i + 1] = c2;
            chavesU[i + 2] = c3;
            chavesU[i + 3] = c4;
            chavesU[i + 4] = c5;
        }
        return chavesU;
    }

    /**
     * Retorna um array com as estrelas introduzidas pelo utilizador
     * @return Array com as estrelas do utilizador
     */
    public static int[] estrelasUtilizador() {
        Scanner inputReader = new Scanner(System.in);
        System.out.println("Agora escreve 2 números para as estrelas: ");
        int e1 = inputReader.nextInt();
        int e2 = inputReader.nextInt();

        int[] estrelasU = new int[2];
        // Mete num array as estrelas do utilizador
        for (int j = 0; j < 1; j += 2) {
            estrelasU[j] = e1;
            estrelasU[j + 1] = e2;
        }
        return estrelasU;
    }

    /**
     * Cria um array com a chave vencedora
     */
    public static int[] geracaoChaveVencedora() {
        int[]chavesV = new int[5];
            for (int i = 0; i < 5; i++)
                chavesV[i] = numeroAleatorio(1,50);
        return chavesV;
    }

    /**
     * Cria um array com as estrelas vencedoras
     */
    public static int[] geracaoEstrelasVencedoras() {
        int[] estrelasV = new int[2];
        for (int i = 0; i < 1; i++)
            estrelasV[i] = numeroAleatorio(1, 12);
        return estrelasV;
    }

    /**
     * Função responsável por simular o Euromilhões
     */
    public static void executarPrograma() {
        int[] chavesU = chaveUtilizador();
        int[] estrelasU = estrelasUtilizador();

        int[] chaveV = geracaoChaveVencedora();
        int[] estrelasV= geracaoEstrelasVencedoras();
        
        System.out.println("Chave introduzida " + "-> " + chavesU[0] +" "+ chavesU[1] +" "+ chavesU[2] +" "+ chavesU[3]+" "+ chavesU[4]+ ","+ estrelasU[0] +" "+ estrelasU[1]);

        System.out.println("-----------------------------------------------------------");
        System.out.println("------------------Sorteio do Euromilhões-------------------");
        
        for (int i = 0; i<5; i++){
            System.out.println("Numero vencedor " + (i + 1) + " anunciado: " + "-> "+ chaveV[i]);
        }

        System.out.println(" ");
        for (int j = 0; j<2; j++){
            System.out.println("Estrela vencedora " + (j + 1) + " anunciada: " +"-> "+ estrelasV[j]);
        }

        System.out.println("-----------------------------------------------------------");

        if (Arrays.equals(chavesU, chaveV) && Arrays.equals(estrelasU, estrelasV))
            System.out.println ("Parabéns, acabou de ganhar uma pipa de massa! ");
        else
            System.out.println ("Já foste, para a semana há mais...");
    }


    public static void main(String[] args){
                executarPrograma();
    }
}


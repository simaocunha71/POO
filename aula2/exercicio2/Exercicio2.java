import java.util.Arrays;
import java.util.Scanner;

public class Exercicio2 {
    /**
     * Função interativa que retorna uma matriz dada pelo utilizador
     * @return Matriz dada pelo utilizador
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

    public static void e1() {
        Scanner inputReader = new Scanner(System.in);
        int[][] matriz = devolveMatriz();   
        
        System.out.println("Escreve o numero do aluno que se quer saber a nota: ");
        int aluno = inputReader.nextInt();
        
        System.out.println("Escreve a Unidade Curricular: ");
        int uc = inputReader.nextInt();
        
        int nota = AuxEx2.leNota(aluno, uc, matriz);
        System.out.println("A nota do aluno "+aluno+ "é: "+nota);
    }
    
    public static void e2() {
        Scanner inputReader = new Scanner(System.in);
        int[][] matriz = devolveMatriz();

        System.out.println("Escreve a nova nota a ser inserida: ");
        int novaNota = inputReader.nextInt();
        
        System.out.println("Escreve o numero do aluno que se quer mudar a nota: ");
        int aluno = inputReader.nextInt();
        
        System.out.println("Escreve a UC: ");
        int uc = inputReader.nextInt();
        
        AuxEx2.atualiza(novaNota, aluno, uc, matriz);
        System.out.println("Pauta atualizada:" + Arrays.toString(matriz));
    }

    public static void e3() {
        Scanner inputReader = new Scanner(System.in);
        int[][] matriz = devolveMatriz();

        System.out.println("Qual é a UC que quer saber a soma das notas: ");
        int uc = inputReader.nextInt();

        int soma = AuxEx2.somaNotasUC(uc, matriz);
        System.out.println("Soma das notas da UC "+uc+": "+soma);
    }
    
    public static void e4() {
        Scanner inputReader = new Scanner(System.in);
        int[][] matriz = devolveMatriz();

        System.out.println("Escreva o numero do aluno: ");
        int aluno = inputReader.nextInt();

        int media = AuxEx2.mediaAluno(aluno, matriz);
        System.out.println("Media do aluno "+aluno+": " + media);
    }

    public static void e5() {
        Scanner inputReader = new Scanner(System.in);
        int[][] matriz = devolveMatriz();

        System.out.println("Escreva o numero da UC: ");
        int uc = inputReader.nextInt();

        int mediaUC = AuxEx2.mediaUC(uc, matriz);
        System.out.println("Media da UC " + uc + ": " + mediaUC);
    }

    public static void e6() {
        int[][] matriz = devolveMatriz();

        int notaMaisAlta = AuxEx2.notaMaisAlta(matriz);
        int notaMaisBaixa = AuxEx2.notaMaisBaixa(matriz);
        System.out.println("A nota mais alta da turma é: " + notaMaisAlta);
        System.out.println("A nota mais baixa da turma é: " + notaMaisBaixa);
    }

    public static void e7() {
        Scanner inputReader = new Scanner(System.in);
        int[][] matriz = devolveMatriz();

        System.out.println("Escreve uma nota: ");
        int notaDelimitadora = inputReader.nextInt();

        int[] array = AuxEx2.notasAcima(notaDelimitadora,matriz);
        System.out.println("Notas acima: " + Arrays.toString(array));
    }

    public static void e8() {
        int[][] matriz = devolveMatriz();
        AuxEx2.pauta (matriz);
    }

    public static void e9() {
        int[][] matriz = devolveMatriz();
        int r = AuxEx2.melhorUC(matriz);
        System.out.println("A UC com melhor media de aprovados é " + r);
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
            case 4:
                e4();
                break;
            case 5:
                e5();
                break;
            case 6:
                e6();
                break;
            case 7:
                e7();
                break;
            case 8:
                e8();
                break;
            case 9:
                e9();
                break;
            default:
                break;
        }
    }
}

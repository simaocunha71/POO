
public class Auxiliares {
    /**
     * Converte graus para Farenheit
     * @param graus valor a converter
     * @return Valor em Farenheit
     */
    public static double celsiusParaFarenheit(double graus) {
        return ((graus * 1.8) + 32);
    }

    /**
     * Calcula o máximo entre 2 números
     * @param a valor a
     * @param b valor b
     * @return o maior entre a e b
     */
    public static int max(int a, int b) {
       return (a > b ? a : b);
    }

    /**
     * Imprime o nome de utilizador, juntamente com o seu saldo
     * @param nome Nome do utilizador
     * @param saldo Saldo
     * @return Impressão da descrição
     */
    public static String criaDescricaoConta(String nome, double saldo) {
        return ("Nome de utilizador: " + nome + "; Saldo: " + saldo);
    }

    /**
     * Converte euros para libras
     * @param valor Valor em euros
     * @param taxaConversao taxa de conversao para libras
     * @return Valor em libras
     */
    public static double convertEuros(double valor, double taxaConversao) {
        return (valor * taxaConversao);
    }

   /**
    * Lê dois inteiros e escreve-os por ordem decrescente, assim como a sua média.
    * @param n1 numero 1 a usar
    * @param n2 numero 2 a usar
    * @return string com a ordenação e média dos valores
    */
    public static String ordDecresc(int n1, int n2) {
        int media = (n1 + n2) / 2;
        String res;
        if (n1 > n2) {
            res = ("A ordem correta é: " + n1 + " -> " + n2 + ", cuja média é" + media);
        } else
            res = ("A ordem correta é: " + n2 + " -> " + n1 + ", cuja média é" + media);
        return res;
    }

    /**
     * Devolve o fatorial de um numero
     * @param n
     * @return Fatorial de n
     */
    public static long fact(long n){
        long res = 1;
        if (n >= 2) {
            for (long i = 1; i < n; i++){
                res *= i;
            }  
        }
        return res; 
    }
}
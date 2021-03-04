/**
 * Auxiliares
 */
public class Auxiliares {

    /**
     * Calcula o valor minimo de um array
     * @param array Array onde se vai procurar o valor minimo
     * @return Valor mínimo
     */
    public static int valorMinimo(int[] array) {
        int min = array [0];
        for (int i: array){
            if (i<min){
                min = i;
            }
        }
        return min;
    }

    /**
     * Retorna o array entre os indices "inicio" e "fim"
     * @param a Array inicial
     * @param inicio Indice inicial
     * @param fim Indice final
     * @return Array entre indices "inicio" e "fim"
     */
    public static int[] entreIndices(int[] a, int inicio, int fim) {
        if (inicio>fim || fim>a.length || fim < 0 || inicio < 0){
            return null; //devemos colocar "null" em vez de um array vazio
        }
        int tamanho = fim-inicio+1;
        int[] res = new int[tamanho];
        System.arraycopy(a, inicio, res, 0, tamanho);
        return res;
    }

    /**
     * Determina o array com os elementos comuns de 2 arrays
     * @param a1 array 1
     * @param a2 array 2
     * @return array com os elementos comuns de a1 e a2
     */
    public int[] comuns (int[]a1, int[]a2){
        int[]res = new int[a1.length];
        int ind = 0;

        for(int elem1: a1){
            boolean encontr = false;
            for (int i = 0; i<a2.length && !encontr; i++){
                if (elem1 == a2[i]){
                    boolean encontrRes = false;
                    for(int j = 0; i<ind && !encontrRes; j++)
                        encontrRes = res[j] == elem1;
                    if (!encontrRes){
                        res[ind++] = elem1;
                    }
                    encontr = true;
                }
            }
        }
        int[] resultado = new int[ind];
        System.arraycopy (res,0, resultado, 0, ind);
        return resultado;
    }
}
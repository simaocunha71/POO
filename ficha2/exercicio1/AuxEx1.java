
public class AuxEx1 {

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
        int[] newArray = new int[fim - inicio + 1];

        for (int i = 0; i < newArray.length; i++)
            newArray[i] = a[i + inicio];

        return newArray;
    }
    
    /**
     * Determina o array com os elementos comuns de 2 arrays
     * @param a1 array 1
     * @param a2 array 2
     * @return array com os elementos comuns de a1 e a2
     */
    public static int[] comuns (int[]a1, int[]a2){
        int[] tempArray = new int[Math.max(a1.length, a2.length)]; //comprimento máximo dos arrays a1 e a2

        int i = 0;
        for (int element1 : a1) { //element1 percorre a1
            for (int element2 : a2) {//element2 percorre a2
                if (element1 == element2) {
                    tempArray[i++] = element1;// coloca num array temporario
                    break;
                }
            }
        }

        int[] newArray = new int[i];
        for (int j = 0; j < i; j++)
            newArray[j] = tempArray[j];

        return newArray;
    }

}


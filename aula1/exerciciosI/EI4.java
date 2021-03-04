import java.lang.Math;

public class EI4 {
    /**
     * Calcula a média de temperaturas e mostra a maior variação de temperaturas
     */
        public static void main (String[] args){
        if(args.length < 2){
            System.out.println("Falta inserir mais um temperatura. ");
        }
        else {
            int atualT = Integer.parseInt(args[0]);
            int antT = Integer.parseInt(args[0]);
            int acc = 0;
            int tmp = 0;
            int indiceAtual = 0;
            int somaT = Integer.parseInt(args[0]);
  
            for (int i = 1; i < args.length; i++) {
                atualT = Integer.parseInt(args[i]);
                tmp = atualT - antT;
                if (Math.abs(tmp) > Math.abs(acc)) {
                    acc = tmp;
                    indiceAtual = i;
                }
                somaT += atualT;
                antT = i;
            }
            int mediaT = somaT / args.length;
            System.out.println("A média das " + args.length + " temperaturas foi de " + mediaT + " graus.");
            if (acc >= 0)
                System.out.println("A maior variação foi entre o dia " + (indiceAtual - 1) + " e " + (indiceAtual) + ", onde a temperatura aumentou " + acc + " graus Celsius.");
            else
                System.out.println("A maior variação foi entre o dia " + (indiceAtual - 1) + " e " + (indiceAtual) + ", onde a temperatura diminuiu " + (Math.abs(acc)) + " graus Celsius.");
        }
    }
}
public class EI3 {
    /**
     * Calcula o nº de notas entre os intervalos [0,5[, [5,10[, [10,15[ e [15,20]
     */
    public static void main(String[] args) {
        int primInt;
        int segInt;
        int terInt;
        int quartInt;
        primInt = segInt = terInt = quartInt = 0;
        String n = " notas."; // se replicar a string "notas" em baixo irá aparecer um warning

        for (int i = 0; i < args.length; i++) {
            int temp = Integer.parseInt(args[i]);
            if (temp >= 0 && temp < 5)
                primInt++;
            else if (temp >= 5 && temp < 10)
                segInt++;
            else if (temp >= 10 && temp < 15)
                terInt++;
            else if (temp >= 15 && temp <= 20)
                quartInt++;
            else {
                System.out.println("A nota numero" + i + "é inválida");
                return;
            }
        }

        System.out.println("Entre [0,5[ temos: " + primInt + n);
        System.out.println("Entre [5,10[ temos: " + segInt + n);
        System.out.println("Entre [10,15[ temos: " + terInt + n);
        System.out.println("Entre [15,20] temos: " + quartInt + n);
    }
}

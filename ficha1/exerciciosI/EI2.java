public class EI2 {
    /**
     * Retorna a soma entre duas datas
     * @param dia Primeiro dia
     * @param hora Primeira hora
     * @param min Primeiro minuto
     * @param seg Primeiro segundo
     * @param dia1 Segundo dia
     * @param hora1 Segunda hora
     * @param min1 Segundo minuto
     * @param seg1 Segundo segundo
     */
    public static void retornaData(int dia, int hora, int min, int seg, int dia1, int hora1, int min1, int seg1) {
        int varD, varH, varM, varS;
        varD = varH = varM = 0;
        varS = seg + seg1;
        while (varS > 59) {
            varM++;
            varS = varS - 60;
        }
        varM = varM + min + min1;
        while (varM > 59) {
            varH++;
            varM = varM - 60;
        }
        varH = varH + hora + hora1;
        while (varH > 23) {
            varD++;
            varH = varH - 24;
        }
        varD = varD + dia + dia1;
        System.out.println(varD + "Dias " + varH + "Horas " + varM + "Minutos " + varS + "Segundos ");
    }

    public static void main(String[] args) {
        int dia = Integer.parseInt(args[0]);
        int hora = Integer.parseInt(args[1]);
        int min = Integer.parseInt(args[2]);
        int seg = Integer.parseInt(args[3]);
        int dia1 = Integer.parseInt(args[4]);
        int hora1 = Integer.parseInt(args[5]);
        int min1 = Integer.parseInt(args[6]);
        int seg1 = Integer.parseInt(args[5]);
        retornaData(dia,hora,min,seg,dia1,hora1,min1,seg1);
    }
}
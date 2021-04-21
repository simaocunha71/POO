public class EI1 {
    /**
     * Retorna o dia da semana
     * @param dia Número do dia
     * @param mes Número do mes
     * @param ano Número do ano
     */
    public static void retornaDia(int dia, int mes, int ano) {
        int res = 0;
        int totalDias = (int) ((ano - 1900) * 365); // alinea i

        // https://www.guj.com.br/t/verificar-se-ano-e-bissexto/374617
        if (ano % 4 == 0 && (ano % 100 != 0 || ano % 400 == 0) && mes < 3)
            totalDias--;

        for (int i = mes; i > 0; i--) {
            if (i == 2)
                totalDias += 28; // somar 28 dias do mes de fevereiro
            else if (i == 4 || i == 6 || i == 9 || i == 11)
                totalDias += 30; // somar os dias de abril,junho,setembro e novembro
            else
                totalDias += 31; // somar os dias dos meses restantes
        }

        res = totalDias % 7; // alinea b,c

        switch (res) {
            case 0:
                System.out.println("Domingo");
                break;
            case 1:
                System.out.println("Segunda-feira");
                break;
            case 2:
                System.out.println("Terça-feira");
                break;
            case 3:
                System.out.println("Quarta-feira");
                break;
            case 4:
                System.out.println("Quinta-feira");
                break;
            case 5:
                System.out.println("Sexta-feira");
                break;
            case 6:
                System.out.println("Sábado");
                break;
            default:
                System.out.println("Não é possível atribuir um dia da semana");
        }
    }

    public static void main(String[] args) {
        int dia = Integer.parseInt(args[0]);
        int mes = Integer.parseInt(args[1]);
        int ano = Integer.parseInt(args[2]);
        retornaDia(dia, mes, ano);
    }
}
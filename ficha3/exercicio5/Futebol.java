public class Futebol {
    private static final int PORINICIAR = 0;
    private static final int DECORRER = 1;
    private static final int TERMINADO = 2;

    private String visitado;
    private String visitante;

    private int estado;

    private int golosVisitado;
    private int golosVisitante;

    /**
     * Construtor para objetos da classe JogoDeFutebol
     */
    public Futebol(){
        // inicializa variáveis de instância
        this.visitado = "EquipaA";
        this.visitante = "EquipaB";
        this.estado = PORINICIAR;
        this.golosVisitado = 0;
        this.golosVisitante = 0;

    }

    public Futebol(String visitado, String visitante, int estado, int golosVisitado, int golosVisitante)
    {
        // inicializa variáveis de instância
        this.visitado = visitado;
        this.visitante = visitante;
        this.estado = estado;
        this.golosVisitado = golosVisitado;
        this.golosVisitante = golosVisitante;
    }

    public Futebol(Futebol jdf){
        // inicializa variáveis de instância
        this.visitado = jdf.getVisitado();
        this.visitante = jdf.getVisitante();
        this.estado = jdf.getEstado();
        this.golosVisitado = jdf.getGolosVisitado();
        this.golosVisitante = jdf.getGolosVisitante();

    }

    /**
     * Devolve o nome da equipa da casa
     * @return Equipa da casa/visitada
     */
    public String getVisitado() {
        return this.visitado;
    }

    /**
     * Devolve o nome da equipa de fora
     * @return Equipa de fora/visitante
     */
    public String getVisitante() {
        return this.visitante;
    }

    /**
     * Devolve o estado de um jogo
     * @return Estado do jogo
     */
    public int getEstado() {
        return this.estado;
    }

    /**
     * Devolve o numero de golos marcados pela equipa da casa
     * @return Golos da equipa da casa
     */
    public int getGolosVisitado() {
        return this.golosVisitado;
    }

    /**
     * Devolve o numero de golos marcados da equipa de fora
     * @return Golos da equipa de fora
     */
    public int getGolosVisitante() {
        return this.golosVisitante;
    }

    /**
     * Inicializa um jogo
     */
    public void startGame() {
        if (this.estado == PORINICIAR)
            this.estado = DECORRER;
    }

    /**
     * Termina um jogo
     */
    public void endGame() {
        if (this.estado == DECORRER)
            this.estado = TERMINADO;
    }

    /**
     * Incrementa o numero de golos da equipa da casa caso o jogo esteja a decorrer
     */
    public void goloVisitado() {
        if (this.estado == DECORRER)
            golosVisitado++;
    }

    /**
     * Incrementa o numero de golos da equipa de fora caso o jogo esteja a decorrer
     */
    public void goloVisitante() {
        if (this.estado == DECORRER)
            golosVisitante++;
    }

    /**
     * Mostra o marcador do jogo numa string
     * @param jdf Jogo de futebol
     * @return String resultado
     */
    public static String resultadoActual(Futebol jdf) {
        if (jdf.estado != PORINICIAR)
            return "Resultado: " + jdf.golosVisitado + "-" + jdf.golosVisitante;
        return "O Jogo ainda não começou";
    }

    public static void main(String[] args) {
        Futebol j1,j2,j3;
        j1 = new Futebol();
        j2 = new Futebol("Benfica", "Porto", DECORRER, 0, 0);
        j3 = new Futebol(j2);

        System.out.println(resultadoActual(j1));
        System.out.println(resultadoActual(j2));
        System.out.println(resultadoActual(j3));
    }

}

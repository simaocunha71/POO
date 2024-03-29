/**
 * Classe que implementa um Ponto num plano2D. As coordenadas do Ponto sÃ£o
 * inteiras.
 *
 * @author MaterialPOO
 * @version 20210305
 */
public class Ponto {

    // variaveis de instancia
    private int x;
    private int y;

    /**
     * Construtores da classe Ponto. Declaraçao dos construtores por omissao
     * (vazio), parametrizado e de copia.
     */

    /**
     * Construtor por omissÃ£o de Ponto.
     */
    public Ponto() {
        this.x = 0;
        this.y = 0;
    }

    /**
     * Construtor parametrizado de Ponto. Aceita como parÃ¢metros os valores para
     * cada coordenada.
     */
    public Ponto(int cx, int cy) {
        this.x = cx;
        this.y = cy;
    }

    /**
     * Construtor de copia de Ponto. Aceita como parametro outro Ponto e utiliza
     * os metodos de acesso aos valores das variaveis de instancia.
     */
    public Ponto(Ponto umPonto) {
        this.x = umPonto.getX();
        // this.x = umPonto.x;
        this.y = umPonto.getY();
    }

    /**
     * metodos de instancia
     */

    /**
     * Devolve o valor da coordenada em x.
     * 
     * @return valor da coordenada x.
     */
    public int getX() {
        return this.x;
    }

    /**
     * Devolve o valor da coordenada em y.
     * 
     * @return valor da coordenada y.
     */
    public int getY() {
        return this.y;
    }

    /**
     * Actualiza o valor da coordenada em x.
     * 
     * @param novoX novo valor da coordenada em X
     */
    public void setX(int novoX) {
        this.x = novoX;
    }

    /**
     * Actualiza o valor da coordenada em y.
     * 
     * @param novoY novo valor da coordenada em Y
     */
    public void setY(int novoY) {
        this.y = novoY;
    }

    /**
     * MÃ©todo que desloca um ponto somando um delta  às coordenadas em x e y.
     * 
     * @param deltaX valor de deslocamento do x
     * @param deltaY valor de deslocamento do y
     */
    public void deslocamento(int deltaX, int deltaY) {
        this.x += deltaX;
        this.y += deltaY;
    }

    /**
     * Método que soma as componentes do Ponto passado como parametro.
     * 
     * @param umPonto ponto que é somado ao ponto receptor da mensagem.
     */
    public void somaPonto(Ponto umPonto) {
        this.x += umPonto.getX();
        this.y += umPonto.getY();
    }

    /**
     * MÃ©todo que move o Ponto para novas coordenadas.
     * 
     * @param novoX novo valor de x.
     * @param novoY novo valor de y.
     */
    public void movePonto(int cx, int cy) {
        this.x = cx; // ou setX(cx)
        this.y = cy; // ou this.setY(cy)
    }

    /**
     * Método que determina se o ponto está no quadrante positivo de x e y
     * 
     * @return booleano que Ã© verdadeiro se x>0 e y>0
     */
    public boolean ePositivo() {
        return (this.x > 0 && this.y > 0);
    }

    /**
     * Método que determina a distnacia de um Ponto a outro.
     * 
     * @param umPonto ponto ao qual se quer determinar a distÃ¢ncia
     * @return double com o valor da distÃ¢ncia
     */
    public double distancia(Ponto umPonto) {

        return Math.sqrt(Math.pow(this.x - umPonto.getX(), 2) + Math.pow(this.y - umPonto.getY(), 2));
    }

    /**
     * Método que determina se o modulo das duas coordenadas sao o mesmo.
     * 
     * @return true, se as coordenadas em x e y forem iguais em valor absoluto.
     */
    private boolean xIgualAy() {
        return (Math.abs(this.x) == Math.abs(this.y));
    }

    public boolean equals(Object o) {
        if (this == o)
            return true;
        if ((o == null) || (this.getClass() != o.getClass()))
            return false;
        Ponto p = (Ponto) o;
        return (this.x == p.getX() && this.y == p.getY());

    }

    /**
     * Método que devolve a representaçao em String do Ponto.
     * 
     * @return String com as coordenadas x e y
     */
    public String toString() {
        return "Cx = " + this.x + " - Cy = " + this.y;
    }

    /**
     * Método que faz uma copia do objecto receptor da mensagem. Para tal invoca o
     * construtor de copia.
     * 
     * @return objecto clone do objecto que recebe a mensagem.
     */

    public Ponto clone() {
        return new Ponto(this);
    }


}


package veiculos;

public class ValorInvalido extends Exception {
    public ValorInvalido() {
        super();
    }

    public ValorInvalido(String msg) {
        super(msg);
    }
}
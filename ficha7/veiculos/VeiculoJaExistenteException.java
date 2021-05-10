package veiculos;

public class VeiculoJaExistenteException extends Exception{
    
    public VeiculoJaExistenteException() {
        super();
    }

    public VeiculoJaExistenteException(String msg) {
        super(msg);
    }
}
package excepciones;

public class ProfesorException extends Exception {
    private static final long serialVersionUID = 7911635775508174059L;

    public ProfesorException(String mensaje) {
        super(mensaje);
    }
}

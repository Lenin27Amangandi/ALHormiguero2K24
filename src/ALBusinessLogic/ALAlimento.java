package ALBusinessLogic;

public abstract class ALAlimento {

    protected String tipo;

    @Override
    public String toString() {

        if (tipo == null) {
            tipo = "";
        }
        return tipo.toUpperCase();
    }

}

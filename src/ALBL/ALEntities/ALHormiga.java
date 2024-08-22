package ALBL.ALEntities;

public abstract class ALHormiga implements IALHormiga {

    protected String ALTipo;

    @Override
    public String toString() {

        if (ALTipo == null) {
            ALTipo = "  ";
        }
        return ALTipo.toUpperCase();
    }

    @Override
    public boolean comer(ALAlimento alimento) {
        return false;
    }

}

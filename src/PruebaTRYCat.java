import ALFramenwork.ALException;

public class PruebaTRYCat {

    int a;
    int b;
    int suma;

    public PruebaTRYCat(int a, int b) {
        try {
            this.a = a;
            this.b = b;

            suma = a / b;
            System.out.println("Esta es la suma: " + suma);

        } catch (Exception e) {
            new ALException(e.getMessage(), getClass().getName(), ", Constrcutor PruebaTRYCat");
        }
    }

}

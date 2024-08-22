import ALDAC.ALGuardarDatos;
import ALFramenwork.ALException;
import ALGUI.ALEcuAntApp;

public class App {
    public static void main(String[] args) throws Exception {

        //new PruebaTRYCat(4, 0);

        try {
            new ALEcuAntApp();
        } catch (Exception e) {
            System.out.println("No se pudo");
        }

        // try {
        // ALGuardarDatos guardarDatos = new ALGuardarDatos();
        // guardarDatos.AlGuardarCVS("1", "Larva", "Asexual", " .... ", " .... ",
        // "Viva");
        // } catch (Exception e) {
        // System.out.println("Error al guardar datos");
        // }

    }
}

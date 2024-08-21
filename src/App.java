import ALDataAccess.ALGuardarDatos;
import ALGUI.ALFecuAntApp;

public class App {
    public static void main(String[] args) throws Exception {

        try {
        new ALFecuAntApp();
        } catch (Exception e) {
        System.out.println("No se pudo");
        }

        // try {
        //     ALGuardarDatos guardarDatos = new ALGuardarDatos();
        //     guardarDatos.AlGuardarCVS("1", "Larva", "Asexual", " .... ", " .... ", "Viva");
        // } catch (Exception e) {
        //     System.out.println("Error al guardar datos");
        // }

    }
}

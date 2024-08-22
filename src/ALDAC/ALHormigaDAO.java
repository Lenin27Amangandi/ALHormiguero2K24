package ALDAC;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import ALDAC.ALDTO.ALHormigaDTO;

public class ALHormigaDAO {

    private ALGuardarDatos alGuardarDatos = new ALGuardarDatos();
    private String rutaArchivo = "ALData/ALHormigueroRegistro.csv";

    public void guardarHormiga(ALHormigaDTO hormiga) {
        alGuardarDatos.AlGuardarCVS(
                hormiga.getIdHormiga(),
                hormiga.getTipoHormiga(),
                hormiga.getSexo(),
                hormiga.getIngestaNativa(),
                hormiga.getGenoAlimento(),
                hormiga.getEstado());
    }

    public List<ALHormigaDTO> leerHormigas() {
        List<ALHormigaDTO> hormigas = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] campos = linea.split(" , ");
                ALHormigaDTO hormiga = new ALHormigaDTO(
                        campos[0], campos[1], campos[2], campos[3], campos[4], campos[5]);
                hormigas.add(hormiga);
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
        return hormigas;
    }

    // Método de actualización y eliminación podría incluirse aquí
    public void actualizarHormiga(ALHormigaDTO hormiga) {
        // Implementación de la actualización de la hormiga en el archivo CSV
    }

    public void eliminarHormiga(String idHormiga) {
        // Implementación de la eliminación de la hormiga del archivo CSV
    }

}

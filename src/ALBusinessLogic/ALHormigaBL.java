package ALBusinessLogic;

import java.util.List;

import ALDataAccess.ALHormigaDAO;
import ALDataAccess.ALDTO.ALHormigaDTO;

public class ALHormigaBL {

    private ALHormigaDAO hormigaDAO = new ALHormigaDAO();

    public void crearHormiga(ALHormigaDTO hormiga) {
        // Implementar la lógica para definir el sexo, tipo, estado basado en
        // genoAlimento e ingestaNativa
        if (hormiga.getGenoAlimento().equals("X") && hormiga.getIngestaNativa().equals("Carnívoro")) {
            hormiga.setSexo("Macho");
            hormiga.setEstado("Guerrero");
        } else if (hormiga.getGenoAlimento().equals("XX")) {
            hormiga.setSexo("Hembra");
            hormiga.setEstado("Reina");
        }
        // Agregar otras reglas de negocio según sea necesario

        hormigaDAO.guardarHormiga(hormiga);
    }

    public List<ALHormigaDTO> obtenerHormigas() {
        return hormigaDAO.leerHormigas();
    }

    public void actualizarHormiga(ALHormigaDTO hormiga) {
        // Implementar la lógica de actualización
        hormigaDAO.actualizarHormiga(hormiga);
    }

    public void eliminarHormiga(String idHormiga) {
        // Implementar la lógica de eliminación
        hormigaDAO.eliminarHormiga(idHormiga);
    }

}

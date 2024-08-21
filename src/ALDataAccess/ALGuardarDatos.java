package ALDataAccess;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ALGuardarDatos {

    String ALHormigasGuardarCVS = "ALHormigueroRegistro.cvs";
    String idHormiga;
    String tipoHormiga;
    String sexo;
    String ingestaNativa;
    String genoAlimento;
    String estado;
    String rutaArchivo = "ALData/ALHormigueroRegistro.csv";

    public void AlGuardarCVS(String idHormiga, String tipoHormiga, String sexo, String ingestaNativa,
            String genoAlimento, String estado) {

        this.idHormiga = idHormiga;
        this.tipoHormiga = tipoHormiga;
        this.sexo = sexo;
        this.ingestaNativa = ingestaNativa;
        this.genoAlimento = genoAlimento;
        this.estado = estado;

        // try (BufferedWriter writer = new BufferedWriter(new
        // FileWriter(ALHormigasGuardarCVS, true))) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo, true))) {
            writer.write(this.idHormiga
                    + " , " + this.tipoHormiga
                    + " , " + this.sexo
                    + " , " + this.ingestaNativa
                    + " , " + this.genoAlimento
                    + " , " + this.estado);
            writer.newLine();
        } catch (Exception e) {
            System.err.println("ERROR ...Al guardar los datos. " + e.getMessage());
        }
    }

    // Utilizando el siguiente codigo
    // Dime como puedo generar una clase ALHormigaDAO y ALHormigaDTO en la cual se
    // pueda sincronizar con el registro de datos ubicados en al archivo
    // ALHormigueroRegistro.csv en el cual pueda hacer un crud y a su vez colocar en
    // el Bl condiciones acerca de que cuando selecciones un tipo de genAlimento e
    // ingesta alimento me ayude a cambiar el sexo, tipo de la hormiga, el tipo estado.
    // La clase Interface debe llamar a la clase HormigaDTO, y la clase HormigaDRO a la 
    // clase HormigaDAO y HormigaDAO a los metodos de la clase ALGuardarDatos

}

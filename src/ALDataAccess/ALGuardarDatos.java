package ALDataAccess;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.net.URL;
import java.nio.file.Paths;
import ALFramenwork.ALConstrols;

import ALFramenwork.ALConstrols;

public class ALGuardarDatos {

    String idHormiga;
    String tipoHormiga;
    String sexo;
    String ingestaNativa;
    String genoAlimento;
    String estado;
    // String rutaArchivo = "ALData/ALHormigueroRegistro.csv";
    String rutaArchivo = ALConstrols.RUTA_ARCHIVO_CSV;

    public void AlGuardarCVS(String idHormiga, String tipoHormiga, String sexo, String ingestaNativa,
            String genoAlimento, String estado) {

        this.idHormiga = idHormiga;
        this.tipoHormiga = tipoHormiga;
        this.sexo = sexo;
        this.ingestaNativa = ingestaNativa;
        this.genoAlimento = genoAlimento;
        this.estado = estado;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo, true))) {
            writer.write(this.idHormiga
                    + " , " + this.tipoHormiga
                    + " , " + this.sexo
                    + " , " + this.ingestaNativa
                    + " , " + this.genoAlimento
                    + " , " + this.estado);
            writer.newLine();
        } catch (Exception e) {
            System.err.println("ERROR ... Al guardar los datos. " + e.getMessage());
        }
    }
}

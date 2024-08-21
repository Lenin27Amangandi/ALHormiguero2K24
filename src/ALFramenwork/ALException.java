package ALFramenwork;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ALException extends Exception {
    public ALException(String e, String clase, String metodo) {
        System.out.println("[ERROR APP --> LOG] " + clase + "." + metodo + " : " + e);
    }

    private void logError(String e, String clase, String metodo) {
        String fechaHora = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        String mensajeLog = "[ERROR APP --> LOG] " + clase + "." + metodo + " : " + e + " [" + fechaHora + "]";
        System.out.println(mensajeLog);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("ALData/ALHormigueroErrorLog.txt", true))) {
            writer.write(mensajeLog);
            writer.newLine();
        } catch (IOException ioException) {
            System.err.println("No se pudo escribir el error en el log: " + ioException.getMessage());
        }
    }

    @Override
    public String getMessage() {
        return "Ups se presento un error..";
    }
}

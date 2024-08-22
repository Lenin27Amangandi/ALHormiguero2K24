package ALFramenwork;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ALException extends Exception {

    public ALException(String e, String clase, String metodo) {
        super(e);
        logError(e, clase, metodo);
        ALConstrols.showMsgError(getCustomMessage());
    }

    // public ALException(String e, String clase, String metodo) {
    // System.out.println("[ERROR APP --> LOG] " + clase + "." + metodo + " : " +
    // e);
    // }

    private void logError(String e, String clase, String metodo) {
        String fechaHora = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        String mensajeLog = "[ERROR APP --> LOG] " + clase + "." + metodo + " : " + e + " [" + fechaHora + "]";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("ALData/ALHormigueroErrorLog.txt", true))) {
            writer.write(mensajeLog);
            writer.newLine();
        } catch (IOException ioException) {
            System.err.println("No se pudo escribir el error en el log: " + ioException.getMessage());
        }
    }

    private String getCustomMessage() {
        return "Ups, se presentó un error.";
    }

    @Override
    public String getMessage() {
        return getCustomMessage();
    }

}

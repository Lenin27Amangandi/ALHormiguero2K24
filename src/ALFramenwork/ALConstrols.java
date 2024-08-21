package ALFramenwork;

import java.net.URL;

import javax.swing.JOptionPane;

public class ALConstrols {

    public static final String RUTA_ARCHIVO_CSV = "ALData/ALHormigueroRegistro.csv";
    public static final String RUTA_ARCHIVO_TXT = "ALData/ALHormiguero.txt";

    public static final URL URL_ALHormigueroTXT = ALConstrols.class.getResource(RUTA_ARCHIVO_TXT);
    public static final URL URL_ALHormigueroRegistroCVS = ALConstrols.class
                            .getResource("/ALHormiguero2K24/" + RUTA_ARCHIVO_CSV);
    public static final URL URL_Logo = ALConstrols.class.getResource("src/ALGUI/ALResource/Logo.jpg");

    // String rutaArchivoCVS = "ALData/ALHormigueroRegistro.csv";
    // String rutaArchivoTXT = "ALData/ALHormiguero.txt";

    // public static final URL URL_ALHormigueroTXT =
    // ALConstrols.class.getResource("ALData/ALHormiguero.txt");

    // public static final URL URL_ALHormigueroRegistroCVS = ALConstrols.class
    // .getResource("/ALHormiguero2K24/ALData/ALHormigueroRegistro.csv");
    // public static final URL URL_Logo =
    // ALConstrols.class.getResource("src/ALGUI/ALResource/Logo.jpg");

    public static final void showMsg(String msg) {
        JOptionPane.showMessageDialog(null, msg, "😏 IABot", JOptionPane.INFORMATION_MESSAGE);
    }

    public static final void showMsgError(String msg) {
        JOptionPane.showMessageDialog(null, msg, "💀 IABot", JOptionPane.OK_OPTION);
    }

    public static final boolean showConfirmYesNo(String msg) {
        return (JOptionPane.showConfirmDialog(null, msg, "😞 ALHormiguero2k24",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION);
    }

}

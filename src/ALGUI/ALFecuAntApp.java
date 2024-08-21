package ALGUI;

import java.awt.LayoutManager;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.LayoutManager;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;

import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import ALBusinessLogic.ALCarnivoro;
import ALBusinessLogic.ALGenoAlimento;
import ALBusinessLogic.ALHervivoro;
import ALBusinessLogic.ALHormigaBL;
import ALBusinessLogic.ALIngestaNativa;
import ALBusinessLogic.ALInsectivoro;
import ALBusinessLogic.ALNectarivoros;
import ALBusinessLogic.ALOmnivoro;
import ALBusinessLogic.AL_XX;
import ALBusinessLogic.AL_XY;
import ALDataAccess.ALDTO.ALHormigaDTO;
import ALBusinessLogic.AL_X;

import javax.swing.JComboBox;
import java.util.ArrayList;

public class ALFecuAntApp extends JFrame {

    public ALFecuAntApp() {
        ALcustumerControls();
        // initHormigas();
    }

    // private void initHormigas() {
    // ALHormigaBL hormigaBl = new ALHormigaBL();
    // ALHormigaDTO nuevaHormiga = new ALHormigaDTO("ID1", "Tipo1", "Sexo1",
    // "Carnívoro", "X", "Viva");
    // hormigaBl.crearHormiga(nuevaHormiga);
    // List<ALHormigaDTO> hormigas = hormigaBl.obtenerHormigas();
    // }

    private void ALcustumerControls() {
        setTitle("EcuAnt2k24");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 700);
        setLayout(new BorderLayout());
        JPanel ALTopPanel = new JPanel(new BorderLayout());

        JLabel ALimagenLabel = new JLabel(new ImageIcon("src/ALGUI/ALResource/Logo.jpg"));
        JLabel ALTitleLabel = new JLabel("Hormiguero Virtual", SwingConstants.CENTER);
        ALTitleLabel.setFont(new Font("Arial", Font.BOLD, 14));
        ALTopPanel.add(ALimagenLabel, BorderLayout.NORTH);
        ALTopPanel.add(ALTitleLabel, BorderLayout.SOUTH);
        add(ALTopPanel, BorderLayout.NORTH);
        this.setLocationRelativeTo(null);

        // Panel para la grilla
        String[] ALcolumnasName = { "Registro", "TipoHormiga", "Sexo", "IngestaNativa", "GenoAlimento",
                "Estado", "Ubicacion" };
        Object[][] ALdata = new Object[8][7];

        DefaultTableModel tableModel = new DefaultTableModel(ALdata, ALcolumnasName);
        JTable table = new JTable(tableModel);

        // JTable table = new JTable(ALdata, ALcolumnasName);
        JScrollPane ALScrollPane = new JScrollPane(table);

        JPanel ALcomboPanel = new JPanel();
        ArrayList<ALGenoAlimento> lstGenoAlimento = new ArrayList<ALGenoAlimento>();
        lstGenoAlimento.add(new AL_X());
        lstGenoAlimento.add(new AL_XX());
        lstGenoAlimento.add(new AL_XY());
        JComboBox<ALGenoAlimento> ALgenCombo = new JComboBox<>(lstGenoAlimento.toArray(new ALGenoAlimento[0]));

        // JPanel ALcomboPanel2 = new JPanel();
        ArrayList<ALIngestaNativa> lstIngestaNativa = new ArrayList<ALIngestaNativa>();
        lstIngestaNativa.add(new ALCarnivoro());
        lstIngestaNativa.add(new ALHervivoro());
        lstIngestaNativa.add(new ALInsectivoro());
        lstIngestaNativa.add(new ALOmnivoro());
        lstIngestaNativa.add(new ALNectarivoros());
        JComboBox<ALIngestaNativa> ALingCombo = new JComboBox<>(lstIngestaNativa.toArray(new ALIngestaNativa[0]));

        ALcomboPanel.add(ALgenCombo);
        ALcomboPanel.add(ALingCombo);

        // Panel Para botones
        JPanel ALbtnPanel = new JPanel(new GridLayout(1, 4, 5, 5));
        JButton ALbtnCrear = new JButton("Crear Larva");
        JButton ALbtnAlimentar = new JButton("Alimentar");
        JButton ALbtnEliminar = new JButton("Eliminar");
        JButton ALbtnGuardar = new JButton("Guardar");
        ALbtnPanel.add(ALbtnCrear);
        ALbtnPanel.add(ALbtnAlimentar);
        ALbtnPanel.add(ALbtnEliminar);
        ALbtnPanel.add(ALbtnGuardar);

        // Panel combinado para los combos y botones
        JPanel ALcomboButtonPanel = new JPanel(new BorderLayout());
        ALcomboButtonPanel.add(ALcomboPanel, BorderLayout.NORTH);
        ALcomboButtonPanel.add(ALbtnPanel, BorderLayout.SOUTH);

        //// Añadir ActionListener para el botón Crear Larva
        ALbtnCrear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Contar las filas actuales
                int rowCount = table.getRowCount();
                // Encontrar la primera fila vacía
                int rowToInsert = -1;
                for (int i = 0; i < rowCount; i++) {
                    if (table.getValueAt(i, 0) == null) {
                        rowToInsert = i;
                        break;
                    }
                }

                if (rowToInsert != -1) {
                    // Crear una nueva fila con los datos predeterminados
                    table.setValueAt(rowToInsert + 1, rowToInsert, 0); // Registro
                    table.setValueAt("Larva", rowToInsert, 1); // TipoHormiga
                    table.setValueAt("Asexual", rowToInsert, 2); // Sexo
                    table.setValueAt("", rowToInsert, 3); // IngestaNativa (vacío)
                    table.setValueAt("", rowToInsert, 4); // GenoAlimento (vacío)
                    table.setValueAt("Vivo", rowToInsert, 5); // Estado
                    table.setValueAt("Sola", rowToInsert, 6); // Ubicacion
                } else {
                    // Si no hay filas vacías, añadir una nueva fila
                    Object[] newRow = { rowCount + 1, "Larva", "Asexual", "", "", "Vivo", "Sola" };
                    ((DefaultTableModel) table.getModel()).addRow(newRow);
                }
            }
        });

        ALbtnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int rowCount = table.getRowCount();
                int lastNonEmptyRow = -1;

                // Buscar la última fila no vacía
                for (int i = 0; i < rowCount; i++) {
                    if (table.getValueAt(i, 0) != null) {
                        lastNonEmptyRow = i;
                    }
                }

                // Si se encontró una fila no vacía
                if (lastNonEmptyRow != -1) {
                    ALHormigaDTO hormiga = new ALHormigaDTO(
                            table.getValueAt(lastNonEmptyRow, 0).toString(), // Registro
                            table.getValueAt(lastNonEmptyRow, 1).toString(), // TipoHormiga
                            table.getValueAt(lastNonEmptyRow, 2).toString(), // Sexo
                            table.getValueAt(lastNonEmptyRow, 3).toString(), // IngestaNativa
                            table.getValueAt(lastNonEmptyRow, 4).toString(), // GenoAlimento
                            table.getValueAt(lastNonEmptyRow, 5).toString() // Estado
                    );

                    // Guardar la última hormiga en el archivo CSV
                    ALHormigaBL hormigaBl = new ALHormigaBL();
                    hormigaBl.crearHormiga(hormiga);
                }
            }
        });

        // Panel Principal que cnotiene las tablas y el panel
        JPanel ALmainPanel = new JPanel(new BorderLayout());
        ALmainPanel.add(ALScrollPane, BorderLayout.CENTER);
        ALmainPanel.add(ALcomboButtonPanel, BorderLayout.SOUTH);

        // Barra de estado
        JPanel statusBar = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel programingLabel = new JLabel("Programacion II");
        JLabel cedulaLabel = new JLabel("Cedula: 1753193828");
        JLabel nombreLabel = new JLabel("Nombres: Lenin Alexander Amangandi Llumiguano");

        // statusBar.add(new JLabel(" "));
        statusBar.add(programingLabel);
        statusBar.add(new JLabel(" | "));
        statusBar.add(cedulaLabel);
        statusBar.add(new JLabel(" | "));
        statusBar.add(nombreLabel);
        add(ALTopPanel, BorderLayout.NORTH);
        add(ALmainPanel, BorderLayout.CENTER);
        add(statusBar, BorderLayout.PAGE_END);
        setVisible(true);
    }

}

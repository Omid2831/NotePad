import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Notepad extends JFrame {
    private JTextArea textArea;
    private JFileChooser fileChooser;

    public Notepad() {
        super("Notepad");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        textArea = new JTextArea();
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        add(new JScrollPane(textArea), BorderLayout.CENTER);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu fileMenu = new JMenu("File");
        menuBar.add(fileMenu);

        JMenuItem newFileItem = new JMenuItem("New");
        newFileItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textArea.setText("");
            }
        });
        fileMenu.add(newFileItem);

        JMenuItem openFileItem = new JMenuItem("Open...");
        openFileItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openFile();
            }
        });
        fileMenu.add(openFileItem);

        JMenuItem saveFileItem = new JMenuItem("Save...");
        saveFileItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                saveFile();
            }
        });
        fileMenu.add(saveFileItem);

        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        fileMenu.add(exitItem);

        fileChooser = new JFileChooser();
    }

    private void openFile() {
        int returnVal = fileChooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try {
                textArea.setText(readFile(file));
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Error reading file: " + e.getMessage());
            }
        }
    }

    private void saveFile() {
        int returnVal = fileChooser.showSaveDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try {
                writeFile(file, textArea.getText());
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Error writing file: " + e.getMessage());
            }
        }
    }

    private String readFile(File file) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;
        while ((line = reader.readLine()) != null) {
            sb.append(line).append("\n");
        }
        reader.close();
        return sb.toString();
    }

    private void writeFile(File file, String text) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        writer.write(text);
        writer.close();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Notepad notepad = new Notepad();
                notepad.setVisible(true);
            }
        });
    }
}
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BotonesApplet extends JFrame implements ActionListener {
    private final JTextField num1Field;
    private final JTextField num2Field;
    private final JTextField resultField;
    private final JButton addButton;
    private final JButton subtractButton;
    private final JButton multiplyButton;
    private final JButton divideButton;
    private final JButton root1Button;
    private final JButton root2Button;
    private final JButton maxButton;
    private final JButton clearButton;

    public BotonesApplet() {
        // Configurar el título y el tamaño del marco
        super("Botones");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crear componentes
        num1Field = new JTextField(10);
        num2Field = new JTextField(10);
        resultField = new JTextField(10);
        resultField.setEditable(false);
        addButton = new JButton("+");
        subtractButton = new JButton("-");
        multiplyButton = new JButton("*");
        divideButton = new JButton("/");
        root1Button = new JButton("√1");
        root2Button = new JButton("√2");
        maxButton = new JButton("max");
        clearButton = new JButton("Limpiar");

        // Agregar Listeners a los botones
        addButton.addActionListener(this);
        subtractButton.addActionListener(this);
        multiplyButton.addActionListener(this);
        divideButton.addActionListener(this);
        root1Button.addActionListener(this);
        root2Button.addActionListener(this);
        maxButton.addActionListener(this);
        clearButton.addActionListener(this);

        // Crear panel para los campos de texto
        JPanel textPanel = new JPanel();
        textPanel.setLayout(new GridLayout(3, 2));
        textPanel.add(new JLabel("Número 1:"));
        textPanel.add(num1Field);
        textPanel.add(new JLabel("Número 2:"));
        textPanel.add(num2Field);
        textPanel.add(new JLabel("Resultado:"));
        textPanel.add(resultField);

        // Crear panel para los botones
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 2));
        buttonPanel.add(addButton);
        buttonPanel.add(subtractButton);
        buttonPanel.add(multiplyButton);
        buttonPanel.add(divideButton);
        buttonPanel.add(root1Button);
        buttonPanel.add(root2Button);
        buttonPanel.add(maxButton);
        buttonPanel.add(clearButton);

        // Agregar paneles al marco
        setLayout(new BorderLayout());
        add(textPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);

    }

    public void actionPerformed(ActionEvent e) {
        try {
            double num1 = Double.parseDouble(num1Field.getText());
            double num2 = Double.parseDouble(num2Field.getText());
            double result = 0;
            if (e.getSource() == addButton) {
                result = num1 + num2;
            } else if (e.getSource() == subtractButton) {
                result = num1 - num2;
            } else if (e.getSource() == multiplyButton) {
                result = num1 * num2;
            } else if (e.getSource() == divideButton) {
                result = num1 / num2;
            } else if (e.getSource() == root1Button) {
                result = Math.sqrt(num1);
            } else if (e.getSource() == root2Button) {
                result = Math.sqrt(num2);
            } else if (e.getSource() == maxButton) {
                result = Math.max(num1, num2);
            } else if (e.getSource() == clearButton) {
                num1Field.setText("");
                num2Field.setText("");
                resultField.setText("");
                return;
            }
            resultField.setText(String.valueOf(result));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor ingresa números válidos", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        BotonesApplet frame = new BotonesApplet();
        frame.setVisible(true);
    }
}

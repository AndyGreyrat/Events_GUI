import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

public class ColorFrame extends JFrame {
    private final JSlider sliderR; // Deslizador para el componente rojo
    private final JSlider sliderG; // Deslizador para el componente verde
    private final JSlider sliderB; // Deslizador para el componente azul
    private int R, G, B;
    private final JLabel labelR, labelG, labelB;

    public ColorFrame() {
        // Crea los deslizadores
        sliderR = new JSlider(JSlider.HORIZONTAL, 0, 255, 0);
        sliderG = new JSlider(JSlider.HORIZONTAL, 0, 255, 0);
        sliderB = new JSlider(JSlider.HORIZONTAL, 0, 255, 0);

        // Crea las etiquetas para mostrar los valores de los deslizadores
        labelR = new JLabel("R: 0");
        labelG = new JLabel("G: 0");
        labelB = new JLabel("B: 0");

        // Agrega los deslizadores y las etiquetas al frame
        setLayout(new GridLayout(7, 1));
        add(new JLabel("R"));
        add(sliderR);
        add(labelR);
        add(new JLabel("G"));
        add(sliderG);
        add(labelG);
        add(new JLabel("B"));
        add(sliderB);
        add(labelB);

        // Agrega un panel para dibujar el rectángulo
        JPanel panel = new JPanel() {
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(new Color(R, G, B));
                g.fillRect(10, 10, getWidth() - 20, getHeight() - 20);
            }
        };
        add(panel);

        // Agrega un listener a los deslizadores para actualizar el color del rectángulo y las etiquetas
        ChangeListener listener = e -> {
            R = sliderR.getValue();
            G = sliderG.getValue();
            B = sliderB.getValue();
            labelR.setText("R: " + R);
            labelG.setText("G: " + G);
            labelB.setText("B: " + B);
            panel.repaint();
        };
        sliderR.addChangeListener(listener);
        sliderG.addChangeListener(listener);
        sliderB.addChangeListener(listener);

        // Configura el tamaño y la posición del frame
        setSize(400, 400);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        ColorFrame frame = new ColorFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

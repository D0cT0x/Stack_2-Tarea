import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana {
    private JPanel principal;
    private JTextArea txtCodigo;
    private JButton btnComprobar;
    private JLabel lblResultado;
    private JLabel lblParentesis;
    private JLabel lblCorchetes;
    private JLabel lblLlaves;

    Pila pila = new Pila();

    public static void main(String[] args) {
        JFrame frame = new JFrame("Ventana");
        frame.setContentPane(new Ventana().principal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public Ventana() {
        btnComprobar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String codigo = txtCodigo.getText();
                    contarAperturas(codigo);
                    if (pila.balanceado(codigo)) {
                        lblResultado.setText("codigo balanceado");
                    } else {
                        lblResultado.setText("codigo no balanaceado");
                    }
                }catch (Exception ex){
                    lblResultado.setText(ex.getMessage());
                }
            }
        });
    }

    private void contarAperturas(String codigo) {
        int parentesis = 0;
        int corchetes = 0;
        int llaves = 0;

        for (int i = 0; i < codigo.length(); i++) {
            char actual = codigo.charAt(i);
            if (actual == '(') parentesis++;
            if (actual == '[') corchetes++;
            if (actual == '{') llaves++;
        }

        lblParentesis.setText("Paréntesis: " + parentesis);
        lblCorchetes.setText("Corchetes: " + corchetes);
        lblLlaves.setText("Llaves: " + llaves);
    }

}

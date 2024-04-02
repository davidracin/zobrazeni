import javax.swing.*;

public class Tabulka extends JFrame {
    private JPanel panelTabulky;
    private JTable tabulka;

    public Tabulka(SpravceDeskovek spravceDeskovek) {
        tabulka.setModel(new TabulkaDeskovek(spravceDeskovek));
        setContentPane(panelTabulky);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Tabulka s deskovky");
        setSize(400, 300);
    }
}

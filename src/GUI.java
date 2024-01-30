import javax.swing.*;

public class GUI extends JFrame {
    private JCheckBox checkBox;
    private JRadioButton radBtn1;
    private JRadioButton radBtn2;
    private JRadioButton radBtn3;
    private JTextField textField;
    private JPanel mainPanel;
    private JButton btnPrevious;
    private JButton btnSave;
    private JButton btnNext;

    private int indexAktualniDeskovky = 0;
    private SpravceDeskovek spravceDeskovek;

    public GUI(SpravceDeskovek spravceDeskovek) {
        initComponents();
        updateGUI();
        this.spravceDeskovek = spravceDeskovek;
        btnNext.addActionListener(e -> dalsiDeskovka());
        btnPrevious.addActionListener(e -> predchoziDeskovka());
        btnSave.addActionListener(e -> ulozDeskovku());
    }

    private void ulozDeskovku() {
        String nazevHry = textField.getText();
        boolean zakoupeno = checkBox.isSelected();
        int oblibenost = 1;
        if (radBtn2.isSelected()) {
            oblibenost = 2;
        } else if (radBtn3.isSelected()) {
            oblibenost = 3;
        }
        Deskovka aktualniDeskovka = spravceDeskovek.getDeskovka(indexAktualniDeskovky);
        aktualniDeskovka.setNazevHry(nazevHry);
        aktualniDeskovka.setZakoupeno(zakoupeno);
        aktualniDeskovka.setOblibenost(oblibenost);
    }

    private void predchoziDeskovka() {
        if (indexAktualniDeskovky > 0) {
            indexAktualniDeskovky--;
            updateGUI();
        }
    }

    private void dalsiDeskovka() {
        if (indexAktualniDeskovky < spravceDeskovek.getPocetDeskovek() - 1) {
            indexAktualniDeskovky++;
            updateGUI();
        }
    }

    private void initComponents() {
        setContentPane(mainPanel);
        setTitle("Zobrazení dat ze souboru");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
    }
    private void updateGUI() {
        if (spravceDeskovek.getPocetDeskovek() == 0) {
            textField.setText("");
            checkBox.setSelected(false);
            radBtn1.setSelected(true);
        }else {Deskovka aktualniDeskovka = spravceDeskovek.getDeskovka(indexAktualniDeskovky);
                textField.setText(aktualniDeskovka.getNazevHry());
                checkBox.setSelected(aktualniDeskovka.isZakoupeno());
                switch (aktualniDeskovka.getOblibenost()) {
                    case 1:
                        radBtn1.setSelected(true);
                        break;
                    case 2:
                        radBtn2.setSelected(true);
                        break;
                    case 3:
                        radBtn3.setSelected(true);
                        break;
                }
        }
    }
}
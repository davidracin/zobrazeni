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
    private JButton btnTable;

    private int indexAktualniDeskovky = 0;
    private final SpravceDeskovek spravceDeskovek;

    public GUI(SpravceDeskovek spravceDeskovek) {
        this.spravceDeskovek = spravceDeskovek;
        initComponents();
        updateGUI();
        btnNext.addActionListener(e -> dalsiDeskovka());
        btnPrevious.addActionListener(e -> predchoziDeskovka());
        btnSave.addActionListener(e -> {
            try {
                ulozDeskovku();
            } catch (OblibenostException ex) {
                throw new RuntimeException(ex.getLocalizedMessage());
            }
        });
    }

    private void initComponents() {
        setContentPane(mainPanel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Čtení ze souboru");
        pack();
        btnTable.addActionListener(e -> zobrazTabulku());
    }
    private void zobrazTabulku() {
        Tabulka tabulka = new Tabulka(spravceDeskovek);
        tabulka.setVisible(true);
    }

    private void ulozDeskovku() throws OblibenostException {
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
        spravceDeskovek.setDeskovka(indexAktualniDeskovky, aktualniDeskovka);
    }

    private void predchoziDeskovka() {
        btnNext.setEnabled(true);
        if (indexAktualniDeskovky > 0) {
            indexAktualniDeskovky--;
            updateGUI();
        }
    }

    private void dalsiDeskovka() {
        btnPrevious.setEnabled(true);
        if (indexAktualniDeskovky < spravceDeskovek.getPocetDeskovek() - 1) {
            indexAktualniDeskovky++;
            updateGUI();
        }
    }

    private void updateGUI() {
        if (indexAktualniDeskovky == 0) {
            btnPrevious.setEnabled(false);
        }
        if (indexAktualniDeskovky == spravceDeskovek.getPocetDeskovek() - 1) {
            btnNext.setEnabled(false);
        }
        if (spravceDeskovek.getPocetDeskovek() == 0) {
            textField.setText("");
            checkBox.setSelected(false);
            radBtn1.setSelected(true);
        }else {
                Deskovka aktualniDeskovka = spravceDeskovek.getDeskovka(indexAktualniDeskovky);
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
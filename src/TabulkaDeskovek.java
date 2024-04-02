import javax.swing.table.AbstractTableModel;

public class TabulkaDeskovek extends AbstractTableModel {
    private final SpravceDeskovek spravceDeskovek;
    public TabulkaDeskovek(SpravceDeskovek spravceDeskovek) {
        this.spravceDeskovek = spravceDeskovek;
    }

    @Override
    public int getRowCount() {
        return spravceDeskovek.getPocetDeskovek();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Deskovka deskovka = spravceDeskovek.getDeskovka(rowIndex);
        return switch (columnIndex) {
            case 0 -> deskovka.getNazevHry();
            case 1 -> (deskovka.isZakoupeno() ? "ano" : "ne");
            case 2 -> {
                if (deskovka.getOblibenost() == 1) {
                    yield "Nejméně oblíbená";
                } else if (deskovka.getOblibenost() == 2) {
                    yield "Oblíbená";
                } else {
                    yield "Nejvíce oblíbená";
                }
            }
            default -> throw new IllegalArgumentException("Neplatný index sloupce");
        };
    }
    @Override
    public String getColumnName(int columnIndex) {
        return switch (columnIndex) {
            case 0 -> "Název hry";
            case 1 -> "Zakoupeno";
            case 2 -> "Oblíbenost";
            default -> throw new IllegalArgumentException("Neplatný index sloupce");
        };
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
}

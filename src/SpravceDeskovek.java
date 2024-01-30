import java.util.ArrayList;
import java.util.List;

public class SpravceDeskovek {
    private List<Deskovka> seznamDeskovek = new ArrayList<>();
    Deskovka deskovka1 = new Deskovka("Carcassonne", true, 3);
    seznamDeskovek.add(deskovka1);

    public Deskovka getDeskovka(int index) {
        return seznamDeskovek.get(index);
    }

    public int getPocetDeskovek() {
        return seznamDeskovek.size();
    }
}

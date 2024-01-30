import java.util.ArrayList;
import java.util.List;

public class SpravceDeskovek {
    private List<Deskovka> seznamDeskovek = new ArrayList<>();

    public Deskovka getDeskovka(int index) {
        return seznamDeskovek.get(index);
    }

    public int getPocetDeskovek() {
        return seznamDeskovek.size();
    }
}

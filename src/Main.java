public class Main {
    public static void main(String[] args) {
        SpravceDeskovek spravceDeskovek = new SpravceDeskovek();
        GUI gui = new GUI(spravceDeskovek);
        gui.setVisible(true);
    }
}
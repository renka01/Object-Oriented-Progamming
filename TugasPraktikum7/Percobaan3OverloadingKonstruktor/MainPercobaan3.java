package TugasPraktikum7.Percobaan3OverloadingKonstruktor;

public class MainPercobaan3 {
    public static void main(String[] args) {
        Kucing a = new Kucing("Tom");
        a.info();
        System.out.println();
        Kucing b = new Kucing("Milo", 4);
        b.info();
    }
}

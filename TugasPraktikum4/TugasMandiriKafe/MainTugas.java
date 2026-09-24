package TugasPraktikum4.TugasMandiriKafe;

public class MainTugas {
    public static void main(String[] args) {
        Menu Kopi = new Menu("Espresso Double Shot", 25000);
        Menu Latte = new Menu("Caramel Macchiato", 35000);
        Menu Croissant = new Menu("Croissant Butter", 28000);

        Meja meja7 = new Meja(7, 4);

        Pesanan order1 = new Pesanan("ORD-2026-001", meja7);
        order1.tambahItem(Kopi, 2);
        order1.tambahItem(Latte, 1);
        order1.tambahItem(Croissant, 3);
        order1.info();

        MesinKasir kasirUtama = new MesinKasir("KASIR-LANTAI-1");
        order1.bayarDanCetak(kasirUtama);
    }
}

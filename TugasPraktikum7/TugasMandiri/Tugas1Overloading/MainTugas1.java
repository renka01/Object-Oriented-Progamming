package TugasPraktikum7.TugasMandiri.Tugas1Overloading;

public class MainTugas1 {
    public static void main(String[] args) {
        Segitiga t = new Segitiga();
        System.out.println("Jumlah duat sudut lain: " + t.sisaSudut(60));
        System.out.println("Sudut ketiga: " + t.sisaSudut(60, 50));
        System.out.println("Keliling 30, 40, 50: " + t.keliling(30, 40, 50));
        System.out.println("Keliling siku 3, 4: " + t.keliling(3, 4));
        System.out.println("Keliling siku 5, 12: " + t.keliling(5, 12));
    }
}

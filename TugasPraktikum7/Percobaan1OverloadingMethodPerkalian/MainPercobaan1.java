package TugasPraktikum7.Percobaan1OverloadingMethodPerkalian;

public class MainPercobaan1 {
    public static void main(String[] args) {
        Perkalian p = new Perkalian();
        System.out.println("kali(25, 43)          = "+p.kali(25, 43));
        System.out.println("kali(15, 30, 45)      = "+p.kali(15, 30, 45));
        System.out.println("kali(11.0, 20.0)      = "+p.kali(11.0, 20.0));

        p.tampilkan(1, "Perkalian");
        p.tampilkan("Perkalian", 1);
    }
}

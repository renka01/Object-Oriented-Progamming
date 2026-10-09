package TugasPraktikum7.Percobaan5OverloadingOverridingBersama;

public class MainPercobaan5 {
    public static void main(String[] args) {
        Staff usman = new Staff("003", "Usman", "2", 10, 10000);
        Staff anugrah = new Staff("004", "Anugrah", "3", 5, 15000);

        Manager tedjo = new Manager("111", "Tedjo", "1", 5000000, "Administrasi", new Staff[]{usman, anugrah});

        tedjo.lihatInfo();

        System.out.println();
        System.out.println("Simulasi lembur usmann 20 jam @ 15000 =  " + (long) usman.getGaji(20, 15000));
    }
}

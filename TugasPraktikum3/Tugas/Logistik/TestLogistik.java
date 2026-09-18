package TugasPraktikum3.Tugas.Logistik;

import java.util.Scanner;

public class TestLogistik {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Kontainer kontainerAlfa = new Kontainer("REQ-123", "PT. Maju Bersama Wawan", 5000);

        System.out.println("==================================================");
        System.out.println("          SISTEM LOGISTIK KONTAINER               ");
        System.out.println("==================================================");
        System.out.println("Nomor Resi             : " + kontainerAlfa.getNomorResi());
        System.out.println("Nama Pemilik Kontainer : " + kontainerAlfa.getNamaPemilik());
        System.out.println("Kapasitas Maksimal     : " + kontainerAlfa.getKapasitasMaksimal() + " kg");
        System.out.println("Berat Muatan Awal      : " + kontainerAlfa.getBeratMuatanKini() + " kg");
        System.out.println("--------------------------------------------------");

        // 1. Input Penambahan Muatan
        System.out.print("\nMasukkan berat muatan yang ingin ditambahkan (kg): ");
        int beratMasuk = input.nextInt();
        kontainerAlfa.setTambahBerat(beratMasuk);
        System.out.println("Berat Muatan Kini: " + kontainerAlfa.getBeratMuatanKini() + " kg");

        // 2. Input Pembongkaran Muatan
        System.out.print("\nMasukkan berat muatan yang ingin dibongkar (kg): ");
        int beratKeluar = input.nextInt();
        kontainerAlfa.setBongkarMuat(beratKeluar);
        System.out.println("Berat Muatan Kini: " + kontainerAlfa.getBeratMuatanKini() + " kg");

        input.close();
    }
}


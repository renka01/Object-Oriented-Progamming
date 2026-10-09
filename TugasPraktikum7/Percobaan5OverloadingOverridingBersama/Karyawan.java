package TugasPraktikum7.Percobaan5OverloadingOverridingBersama;

public class Karyawan {
    private String nip, nama, golongan;
    private Double gajiPokok;

    public Karyawan(String nip, String nama, String golongan){
        this.nip = nip;
        this.nama = nama;
        this.golongan = golongan;
        this.gajiPokok = hitungGajiPokok(golongan);
    }
    public static double hitungGajiPokok(String golongan){
        switch (golongan){
            case "1": return 5000000;
            case "2": return 3000000;
            case "3": return 2000000;
            case "4": return 1000000;
            case "5": return 750000;
            default: throw new IllegalArgumentException("Golongan tidak ditemukan: " + golongan);
        }
    }
    public String getNama(){
        return nama;
    }
    public double getGaji(){
        return  gajiPokok;

    }
    public void lihatInfo(){
        System.out.println("NIP: " + nip);
        System.out.println("Nama: " + nama);
        System.out.println("Golongan: " + golongan);
        System.out.println("Gaji Pokok: " + getGaji());
    }
}

package TugasPraktikum7.Percobaan3OverloadingKonstruktor;

public class Kucing {
    private String nama;
    private int umur;

    public Kucing(String nama) {
        this.nama = nama;
        
        System.out.println("Konstruktor 1 parameter selesai");
    }
    
    public Kucing(String nama, int umur){
        this.nama = nama;
        this.umur = umur;
        System.out.println("Konstruktor 2 parameter selesai");
    }

    public void info(){
        System.out.println("Kucing " + nama + ", umur " + umur + " tahun");
    }
    
}

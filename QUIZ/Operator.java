package QUIZ;
//Faren Hafiza Afanda TI-2G
//NIM : 254107020025
//Absen 8
public class Operator {
    private String nama;
    private double biayaLayananPerTiket;

    public Operator(String nama,double biayaLayananPerTiket){
        this.nama = nama;
        this.biayaLayananPerTiket = biayaLayananPerTiket;
    }

    public String getNama() {
        return nama;
    }
    public void setNama(String nama) {
        this.nama = nama;
    }
    public double getBiayaLayananPerTiket() {
        return biayaLayananPerTiket;
    }
    public void setBiayaLayananPerTiket(double biayaLayananPerTiket) {
        this.biayaLayananPerTiket = biayaLayananPerTiket;
    }
    public double hitungTotalBiayaLayanan(int jumlahTiket){
        return jumlahTiket * biayaLayananPerTiket;
    }
    public String info(){
        return "Operator " + nama + " (Biaya Layanan Per Tiket: Rp " + String.format("%,.0f", biayaLayananPerTiket) + ")";
    }
    

    
}

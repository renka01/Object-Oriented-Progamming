package QUIZ;
//Faren Hafiza Afanda TI-2G
//NIM : 254107020025
//Absen 8 
public class Reservasi {

    private String kodeReservasi;
    private int jumlahTiket;
    private Studio studio;
    private Operator operator;

    public Reservasi(String kodeReservasi,int jumlahTiket,Studio studio,Operator operator){
        this.kodeReservasi = kodeReservasi;
        this.jumlahTiket = jumlahTiket;
        this.studio = studio;
        this.operator = operator;

    }
    public String getKodeReservasi(){
        return kodeReservasi;
    }
    public void setKodeReservasi(String kodeReservasi){
        this.kodeReservasi = kodeReservasi;
    }
    public int getJumlahTiket(){
        return jumlahTiket;
    }
    public void setJumlahTiket(int jumlahTiket){
        this.jumlahTiket = jumlahTiket;
    }
    public Studio getStudio(){
        return studio;
    }
    public void setStudio(Studio studio){
        this.studio = studio;
    }
    public Operator getOperator(){
        return operator;
    }
    public void setOperator(Operator operator){
        this.operator = operator;
    }
    public double hitungTotalHarga(int durasiJam,int jumlahTiket,Studio studio,Operator operator){
        return studio.tarifSewaStudio(durasiJam) + operator.hitungTotalBiayaLayanan(jumlahTiket);
    }
}
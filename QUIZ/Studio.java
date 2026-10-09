package QUIZ;
//Faren Hafiza Afanda TI-2G
//NIM : 254107020025
//Absen 8
public class Studio {
    private String nama;
    private double tarifPerJam;

    public Studio(String nama,double tarifPerJam){
        this.nama = nama;
        this.tarifPerJam =tarifPerJam;
    }
    public String getNama(){
        return nama;
    }
    public void setNama(String nama){
        this.nama = nama;
    }
    public double getTarifPerJam(){
        return tarifPerJam;
    }
    public void setTarifPerJam(double tarifPerJam){
        this.tarifPerJam = tarifPerJam;
    }
     
    public double tarifSewaStudio(int durasiJam){
        return tarifPerJam*durasiJam;
    }
    public String info(){
        return "Studio " + nama + " (Tarif Per Jam: Rp " + String.format("%,.0f", tarifPerJam) + ")";
    }
}

package TugasPraktikum4.TugasMandiriKafe;

public class Menu {
    private String nama;
    private double harga;

    public Menu(String nama,double harga){
        this.nama = nama;
        this.harga = harga;
    }
    public String getNama(){
        return nama;
    }
    public void setNama(String nama){
        this.nama = nama;
    }
    public double getHarga(){
        return harga;
    }
    public void setHarga(double harga){
        this.harga = harga;
    }
    public String info(){
        return nama + " (Rp " + String.format("%,.0f", harga) + ")";
    }
}

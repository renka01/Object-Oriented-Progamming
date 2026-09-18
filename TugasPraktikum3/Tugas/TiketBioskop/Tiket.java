package TugasPraktikum3.Tugas.TiketBioskop;

public class Tiket {
    private String judulFilm;
    private double hargaDasar = 35000;
    private boolean statusPembayaran = false;

    public Tiket (String judul, double harga){
        judulFilm = judul;
        
        if (harga < 0){
            hargaDasar = 35000;
        } else {
            hargaDasar = harga;
        }
            statusPembayaran = false;
    }
    
    
     // 3. Getter judulFilm & setter (opsional)
    public String getJudulFilm() {
        return judulFilm;
    }
    // 4. Getter & setter hargaDasar
    public double getHargaDasar() {
        return hargaDasar;
    }
    // 5. Getter statusPembayaran (HANYA GETTER / READ-ONLY)
    public boolean getStatusPembayaran() {
        return statusPembayaran;
    }
    // 6. Method behavior untuk mengubah status pembayaran
    public void lakukanPembayaran() {
        this.statusPembayaran = true;
    }
}

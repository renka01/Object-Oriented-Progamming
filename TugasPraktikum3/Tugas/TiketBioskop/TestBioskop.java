package TugasPraktikum3.Tugas.TiketBioskop;

public class TestBioskop {
    public static void main(String[] args) {
        Tiket tiket1 = new Tiket("SuperWawan: The Last Man Standing", 40000);
        System.out.println("Film yang ditonton :" + tiket1.getJudulFilm());  
        System.out.println("Harga Tiket :" + tiket1.getHargaDasar());
        System.out.println("Status Pembayaran :" + tiket1.getStatusPembayaran());
        
        System.out.println("\nMemproses Pembayaran...");
        tiket1.lakukanPembayaran();
        System.out.println("Status Pembayaran :" + tiket1.getStatusPembayaran());  
    }
}

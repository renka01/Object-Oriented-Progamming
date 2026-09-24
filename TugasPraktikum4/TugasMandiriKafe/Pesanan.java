package TugasPraktikum4.TugasMandiriKafe;

import java.util.ArrayList;

public class Pesanan {
    private String kodePesanan;
    private Meja meja;
    private ArrayList<DetailPesanan> listDetail;

    public Pesanan(String kodePesanan, Meja meja){
        this.kodePesanan = kodePesanan;
        this.meja = meja;
        this.listDetail = new ArrayList<>();
    }

    public void tambahItem(Menu menu, int jumlah){
        DetailPesanan item = new DetailPesanan(menu, jumlah);
        listDetail.add(item);
    }
    public double hitungTotal(){
        double total = 0;
        for (DetailPesanan item : listDetail){
            total += item.hitungSubTotal();
        }
        return total;
    }
    public void bayarDanCetak(MesinKasir kasir){
        System.out.println("Pesananan " + kodePesanan + "Berhasil dibayar");
        kasir.cetakPesanan("Kode" + kodePesanan + " |Total: Rp. " + String.format("%,.0f", hitungTotal()));
    }
    public void info(){
        System.out.println("Kode Pesanan: " + kodePesanan);
        System.out.println("Lokasi: " + meja.info());
        System.out.println("Daftar Menu: ");
        for (DetailPesanan item : listDetail){
            item.info();
        }
        System.out.println("Total Bayar: Rp " + String.format("%,.0f", hitungTotal()));
    }
}

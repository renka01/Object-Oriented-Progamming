package TugasPraktikum1;

public class Demo {
    public static void main(String[] args) {
        KipasAngin kipas1 = new KipasAngin();
KipasAngin kipas2 = new KipasAngin();
KipasBerdiri kipasBerdiri = new KipasBerdiri();
KipasKecil kipasKecil = new KipasKecil();
RiceCooker riceCooker = new RiceCooker();

kipas1.warnaKipas("Putih");
kipas1.setPowerOn(true);
kipas1.jumlahBilah(3);
kipas1.tambahKecepatan(2);
kipas1.printInfo();

kipas2.warnaKipas("Hitam");
kipas2.setPowerOn(false);
kipas2.jumlahBilah(4);
kipas2.tambahKecepatan(3);
kipas2.printInfo();

kipasBerdiri.warnaKipas("Biru");
kipasBerdiri.setPowerOn(true);
kipasBerdiri.jumlahBilah(3);
kipasBerdiri.tambahKecepatan(2);
kipasBerdiri.setTinggiMaksimal(150);
kipasBerdiri.setSwingOn(true);
kipasBerdiri.printInfo();

kipasKecil.warnaKipas("Merah");
kipasKecil.setPowerOn(true);
kipasKecil.jumlahBilah(4);
kipasKecil.tambahKecepatan(3);
kipasKecil.setPanjangKabel(100);
kipasKecil.setTipePower("USB");
kipasKecil.printInfo();

riceCooker.setNamaObjek("Rice Cooker");
riceCooker.setBrand("Miyako");
riceCooker.setKapasitas(2);
riceCooker.setMode("Masak");
riceCooker.printInfo();
    }   
}

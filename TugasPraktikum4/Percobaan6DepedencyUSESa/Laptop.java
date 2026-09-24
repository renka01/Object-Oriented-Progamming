package TugasPraktikum4.Percobaan6DepedencyUSESa;

public class Laptop {
    private String merk;

    public Laptop(String merk){
        this.merk = merk;
    }

    public void cetakDokumen(Printer printer, String namaFile){
        System.out.println(merk + "Mengirim dokumen ke printer...");
        printer.cetak(namaFile);
    }
    
}
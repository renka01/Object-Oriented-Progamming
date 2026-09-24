package TugasPraktikum4.Percobaan4ArrayOfObjectNMultiplicity;

public class Gerbong {
    private String kode;
    private Kursi[] arrayKursi;

    public Gerbong(String kode, int jumlahKursi) {
        this.kode = kode;
        this.arrayKursi = new Kursi[jumlahKursi];
        this.intKursi();
    }

    private void intKursi() {
        for (int i = 0; i < this.arrayKursi.length; i++) {
            this.arrayKursi[i] = new Kursi(String.valueOf(i + 1));
        }
    }

    public void setPenumpang(Penumpang penumpang, int nomor) {
        if (nomor < 1 || nomor > this.arrayKursi.length) {
            System.out.println("Nomor kursi tidak valid!");
            return;
        }
        if (this.arrayKursi[nomor - 1].getPenumpang() != null) {
            System.out.println("Gagal: Kursi nomor " + nomor + " sudah ditempati oleh " + this.arrayKursi[nomor - 1].getPenumpang().getNama() + "!");
        } else {
            this.arrayKursi[nomor - 1].setPenumpang(penumpang);
        }
    }

    public String info() {
        String info = " ";
        info += "Kode: " + this.kode + "\n";
        for (Kursi kursi : arrayKursi) {
            info += kursi.info();
        }
        return info;
    }

}

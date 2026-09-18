package TugasPraktikum3.Tugas.Logistik;

public class Kontainer {
    private String nomorResi;
    private String namaPemilik;
    private int kapasitasMaksimal;
    private int beratMuatanKini;
    

    public Kontainer(String resi, String pemilik, int kapasitas){
        nomorResi = resi;
        namaPemilik = pemilik;
        kapasitasMaksimal = kapasitas;
        beratMuatanKini = 0;
    }
    public String getNomorResi(){
        return nomorResi;
    }

    public String getNamaPemilik(){
        return namaPemilik;
    }

    public int getKapasitasMaksimal(){
        return kapasitasMaksimal;
    }

    public int getBeratMuatanKini(){
        return beratMuatanKini;
    }

    public void setTambahBerat(int berat){
        if (beratMuatanKini + berat > kapasitasMaksimal){
            System.out.println("Berat muatan melebihi kapasitas maksimal");
        } else {
            beratMuatanKini += berat;
            System.out.println("Berhasil menambah muatan sebesar " + berat + " kg.");
        }
    }

    public void setBongkarMuat(int berat){
        if (beratMuatanKini == 0){
            System.out.println("Kontainer kosong,tidak ada muatan yang bisa di turunkan");
        } else if (berat > beratMuatanKini * 0.5){
            System.out.println("Maaf, demi keselamatan. Pembongkaran muatan satu kali jalan tidak boleh melebihi 50% dari muatan saat ini! ");
        } else {
            beratMuatanKini -= berat;
            System.out.println("Berhasil membongkar muatan sebesar " + berat + " kg.");
        }
    }
}

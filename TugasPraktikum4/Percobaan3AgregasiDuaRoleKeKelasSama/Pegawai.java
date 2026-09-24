package TugasPraktikum4.Percobaan3AgregasiDuaRoleKeKelasSama;

public class Pegawai {
    private String nip,nama;

    public Pegawai(String nip, String nama) {
        this.nip = nip;
        this.nama = nama;
    }
    public void setNip(String nip){
        this.nip = nip;
    }
    public String getNip(){
        return nip;
    }

    public void setNama(String nama){
        this.nama = nama;
    }

    public String getNama(){
        return nama;
    }
    public String info(){
        String info = "";
        info += "NIP: " + this.nip + "\n";
        info += "Nama: " + this.nama + "\n";
        return info;

    }

    
}

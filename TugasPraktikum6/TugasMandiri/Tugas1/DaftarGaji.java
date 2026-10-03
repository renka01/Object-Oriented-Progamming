package TugasPraktikum6.TugasMandiri.Tugas1;

public class DaftarGaji {
    private Pegawai[] listPegawai;
    private int jumlah;

    public DaftarGaji(int kapasitas){
        this.listPegawai = new Pegawai[kapasitas];
    }
    public void addPegawai(Pegawai p){
        if(jumlah < listPegawai.length){
            listPegawai[jumlah] = p;
            jumlah++;
        }
    }
    public void printSemuaGaji(){
        for(int i = 0; i < jumlah; i++){
            System.out.println(listPegawai[i].getNama() + " : " + listPegawai[i].getGaji());
        }
    }
    
}

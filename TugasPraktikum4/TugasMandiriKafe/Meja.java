package TugasPraktikum4.TugasMandiriKafe;

public class Meja {
    private int nomorMeja;
    private int kapasitas;

    public Meja(int nomorMeja, int kapasitas){
        this.nomorMeja = nomorMeja;
        this.kapasitas = kapasitas;
    }
    public int getNomorMeja(){
        return nomorMeja;
    }
    public void setNomorMeja(int nomorMeja){
        this.nomorMeja = nomorMeja;
    }
    public int getKapasitas(){
        return kapasitas;
    }
    public void setKapasitas(int kapasitas){
        this.kapasitas = kapasitas;
    }
    public String info(){
        return "Meja #" + nomorMeja + " (Kapasitas: " + kapasitas + " orang)";
    }
}

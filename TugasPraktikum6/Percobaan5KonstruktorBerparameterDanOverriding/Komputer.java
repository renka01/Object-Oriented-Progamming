package TugasPraktikum6.Percobaan5KonstruktorBerparameterDanOverriding;

public class Komputer {
    protected String merk;
    protected int kapasitasMemory;
    protected int kecepatanCPU;

    public Komputer(String merk, int memory, int cpu){
        this.merk = merk;
        this.kapasitasMemory = memory;
        this.kecepatanCPU = cpu;
    }

    public void showInfo(){
        System.out.println("merk: " + this.merk);
        System.out.println("kapasitasMemory: " + this.kapasitasMemory + " MB");
        System.out.println("kecepatanCPU: " + this.kecepatanCPU + " MHz");
    }
    public void nyalakanKomputer(){
        System.out.println("Komputer " + merk + " dinyalakan");
    }
}

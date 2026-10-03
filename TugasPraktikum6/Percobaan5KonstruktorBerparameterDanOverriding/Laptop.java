package TugasPraktikum6.Percobaan5KonstruktorBerparameterDanOverriding;

public class Laptop extends Komputer{
    protected int resolusiLayar;

    public Laptop(String merk, int memory, int cpu, int layar){
        super(merk, memory, cpu);
        this.resolusiLayar = layar;
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("Resolusi Layar : " + this.resolusiLayar + " pixels");
    }
}

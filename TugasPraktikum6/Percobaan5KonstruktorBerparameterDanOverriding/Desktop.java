package TugasPraktikum6.Percobaan5KonstruktorBerparameterDanOverriding;

public class Desktop extends Komputer {
    protected String printer;

    public Desktop(String merk, int memory, int cpu, String printer){
        super(merk, memory, cpu);
        this.printer = printer;
    }
    @Override 
    public void showInfo(){
        super.showInfo();
        System.out.println("Printer: " + this.printer + " printer");
    }
}

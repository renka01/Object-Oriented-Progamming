package TugasPraktikum7.Percobaan4DasarOverriding;

public class Ikan {
    public void swim(){
        System.out.println("Ikan bisa berenang");

    }
    public Ikan beranak(){
        return new Ikan();
    }
}

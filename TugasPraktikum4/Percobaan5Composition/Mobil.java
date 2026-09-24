package TugasPraktikum4.Percobaan5Composition;

public class Mobil {
    private String merek;
    private Mesin mesin;

    public Mobil(String merek){
        this.merek = merek;
        this.mesin = new Mesin();
    }
    public void tampilkanInfo(){
        System.out.println("Mobil: " + merek);
        System.out.println("Mesin: " + mesin.getTipe());
    }
}

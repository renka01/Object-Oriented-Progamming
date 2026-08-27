package TugasPraktikum1;

public class RiceCooker {
    private String namaObjek;
    private String brand;
    private double kapasitas;
    private String mode;

    public void setNamaObjek(String namaObjek){
        this.namaObjek = namaObjek;
    }
    public void setBrand(String namaBrand){
        brand = namaBrand;
    }

    public void setKapasitas(double kapasitasWadah){
        kapasitas = kapasitasWadah;
    }

    public void setMode(String modeMasak){
        mode = modeMasak;
    }

    public void printInfo(){
        System.out.println("======================");
        System.out.println("Objek: " + namaObjek);
        System.out.println("Brand:" + brand);
        System.out.println("Kapasitas:" + kapasitas + " liter");
        System.out.println("Mode saat ini: " + mode);
    }
}

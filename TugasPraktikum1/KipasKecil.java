package TugasPraktikum1;

public class KipasKecil extends KipasAngin {
    private int panjangKabel;
    private String tipePower;

    public void setPanjangKabel(int kabel){
        panjangKabel = kabel;
    }
    public void setTipePower(String power){
        tipePower = power;
    }

    @Override
    public void printInfo(){
        super.printInfo();
        System.out.println("Panjang Kabel: " + panjangKabel + "cm");
        System.out.println("Tipe Power/Colokan : " + tipePower);
        System.out.println("Tipe Kipas: Kipas Kecil");

    }
}

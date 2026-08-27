package TugasPraktikum1;

public class KipasBerdiri extends KipasAngin {
    private int tinggiMaksimal;
    private boolean isSwingOn;

    public void setTinggiMaksimal(int tinggi){
        tinggiMaksimal = tinggi;
    }

    public void setSwingOn(boolean swingOn){
        isSwingOn = swingOn;
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("Tinggi Maksimal: " + tinggiMaksimal + "cm");
        System.out.println("Swing: " + isSwingOn);
        System.out.println("Tipe Kipas: Kipas Berdiri");
    }
        
    

}

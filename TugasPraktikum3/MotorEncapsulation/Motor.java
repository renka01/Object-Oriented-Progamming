package TugasPraktikum3.MotorEncapsulation;

public class Motor {
    private int kecepatan = 0;
    private boolean kontakOn = false;

    public void nyalakanMesin(){
        kontakOn = true;
    }

    public void matikanMesin(){
        kontakOn = false;
        kecepatan = 0;
    }
    public void tambahKecepatan(){
        if (this.kontakOn == true){
            if (kecepatan < 100) {
                kecepatan += 5;
                if (kecepatan > 100) {
                    kecepatan = 100;
                }
            } else {
                System.out.println("Kecepatan sudah mencapai batas maksimal (100)!");
            }
        } else {
            System.out.println("Kecepatan tidak bisa bertambah karena mesin masih Off");
        }
    }
    public void kurangiKecepatan(){
        if (this.kontakOn == true){
            kecepatan -= 5;
        } else {
            System.out.println("Kecepatan tidak bisa berkurang karena mesin masih Off");
        }
    }
    

    public void printStatus(){
        if (this.kontakOn == true){
            System.out.println(" Kontak On ");
        } else {
            System.out.println(" Kontak Off");
        }
        System.out.println("Kecepatan: " + kecepatan + "\n");
    }
}

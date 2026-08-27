package TugasPraktikum1;

public class KipasAngin {
    private boolean isPowerOn;
    private String warna;
    private int jumlahBilah;
    private int levelSpeed;


    public void setPowerOn(boolean powerOn){
        isPowerOn = powerOn;
    }
    public void warnaKipas(String warnaKipas){
        warna = warnaKipas;
    }
    public void jumlahBilah(int jumlah){
        jumlahBilah = jumlah;
    }

    public void tambahKecepatan(int increment){
        levelSpeed += increment;
        if (levelSpeed > 3){
            levelSpeed = 3;
        }
        
    }
    public void printInfo(){
        System.out.println("=============================");
        System.out.println("Warna Kipas : " + warna);
        System.out.println("Status Menyala : " + isPowerOn );
        System.out.println("Jumlah Bilah: " + jumlahBilah);
        System.out.println("Kecepatan : " + levelSpeed);
    }
        
}


package TugasPraktikum6.Percobaan2HakAksesPadaPewarisan;

public class ClassB extends ClassA {
    public int z;

    public void setZ(int z){
        this.z = z;
    }

    public void getNilaiZ(){
        System.out.println("Nilai z : " + z);
    }
    public void getJumlah(){
        System.out.println("Jumlah : " + (getX() + getY() + z));
    }
    
}

package TugasPraktikum7.TugasMandiri.Tugas2Overriding;

public class Dosen extends Manusia {
    @Override 
    public void makan(){
        super.makan();
        System.out.println("Dosen makan di kantin fakultas,");
    }
    public void lembur(){
        System.out.println("Dosen lembur menilai ujian");
    }

}

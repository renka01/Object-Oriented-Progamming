package TugasPraktikum7.TugasMandiri.Tugas2Overriding;

    public class Mahasiswa extends Manusia{
        @Override 
    public void makan(){
        System.out.println("Mahasiswa makan di kantin kampus");
    }
    public void tidur(){
        System.out.println("Mahasiswa tidur di perpustakaan");
    }
}

package TugasPraktikum7.TugasMandiri.Tugas2Overriding;

public class MainTugas2 {
    public static void main(String[] args) {
        Manusia manusia = new Manusia();
        Dosen dosen = new Dosen();
        Mahasiswa mahasiswa = new Mahasiswa();

        System.out.println("=== Manusia ===");
        manusia.bernafas();
        manusia.makan();

        System.out.println("\n=== Dosen ===");
        dosen.bernafas();
        dosen.makan();
        dosen.lembur();

        System.out.println("\n=== Mahasiswa ===");
        mahasiswa.bernafas();
        mahasiswa.makan();
        mahasiswa.tidur();
    }
}

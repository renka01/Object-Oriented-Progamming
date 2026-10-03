package TugasPraktikum6.TugasMandiri.Tugas1;

public class MainTugas {
    public static void main(String[] args) {
        Pegawai p1 = new Pegawai("111", "Budi", "Jl. A");
        Dosen d1 = new Dosen("222", "Ani", "Jl. B", 3);
        Pegawai p3 = new Pegawai("333", "Citra", "Jl. C");

        DaftarGaji daftar = new DaftarGaji(3);
        daftar.addPegawai(p1);
        daftar.addPegawai(d1);
        daftar.addPegawai(p3);
        daftar.printSemuaGaji();
    }
}

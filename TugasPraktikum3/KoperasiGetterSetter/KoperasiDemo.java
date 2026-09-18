package TugasPraktikum3.KoperasiGetterSetter;

public class KoperasiDemo {
    public static void main(String[] args){
        Anggota anggota1 = new Anggota("Wawan", "Jalan Simbar Menjangan");
        System.out.println("Simpanan " + anggota1.getNama() + ".Rp " + anggota1.getSimpanan());

        anggota1.setNama("Wawan Wirawan");
        anggota1.setAlamat("Jalan Simbar Menjangan No.120");
        anggota1.setor(10000);
        System.out.println("Simpanan " + anggota1.getNama() + " .Rp " + anggota1.getSimpanan());

        anggota1.pinjam(5000);
        System.out.println("Simpanan " + anggota1.getNama() + " .Rp " + anggota1.getSimpanan());
    }
}

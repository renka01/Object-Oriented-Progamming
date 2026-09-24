package TugasPraktikum4.Percobaan3AgregasiDuaRoleKeKelasSama;

public class MainPertanyaan {
    public static void main(String[] args) {
        Pegawai masinis = new Pegawai("2001", "Spiderman");
        KeretaApi keretaApi = new KeretaApi("Mantap Booyah", "Bisnis", masinis);
        System.out.println(keretaApi.info());
    }
}

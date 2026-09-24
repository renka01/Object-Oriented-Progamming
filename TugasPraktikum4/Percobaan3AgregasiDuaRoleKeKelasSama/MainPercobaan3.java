package TugasPraktikum4.Percobaan3AgregasiDuaRoleKeKelasSama;
public class MainPercobaan3 {
    public static void main(String[] args) {
        Pegawai masinis = new Pegawai("2001", "Spiderman");
        Pegawai asisten = new Pegawai("2002", "Thor");

        KeretaApi keretaApi = new KeretaApi("Mantaap Booyah", "Bisnis", masinis, asisten);

        System.out.println(keretaApi.info());
    }
}
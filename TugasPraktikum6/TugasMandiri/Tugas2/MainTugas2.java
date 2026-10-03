package TugasPraktikum6.TugasMandiri.Tugas2;

public class MainTugas2 {
    public static void main(String[] args) {
        TelevisiModern tv = new TelevisiModern("Samsung", 100);
        System.out.println("Channel aktif:" + tv.getChannelAktif());
        tv.pindahChannel(20);
        System.out.println("Channel aktif sekarang:" + tv.getChannelAktif());

        // Televisi tv = new Televisi("Sony", 100);
        tv.gantiModusTampilan("HDMI");
        tv.mainkanDVD();
        tv.masukkanDVD("The Matrix");
        tv.mainkanDVD();
    }
}

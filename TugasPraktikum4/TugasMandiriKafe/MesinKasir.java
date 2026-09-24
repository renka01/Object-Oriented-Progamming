package TugasPraktikum4.TugasMandiriKafe;

public class MesinKasir {
    private String idKasir;

    public MesinKasir(String idKasir){
        this.idKasir = idKasir;
    }
    public void cetakPesanan(String pesan) {
        System.out.println("[STRUK KASIR: "+ idKasir +"]" + pesan);
    }
}

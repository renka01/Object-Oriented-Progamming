package TugasPraktikum4.TugasMandiriKafe;

public class DetailPesanan {
    private Menu menu;
    private int jumlah;

    public DetailPesanan(Menu menu,int jumlah){
        this.menu = menu;
        this.jumlah = jumlah;
    }
    public double hitungSubTotal(){
        return menu.getHarga() * jumlah;
    }
    public void info(){
        System.out.println("- " + menu.getNama() + " x" + jumlah + " = Rp " + String.format("%,.0f", hitungSubTotal()));
    }
}

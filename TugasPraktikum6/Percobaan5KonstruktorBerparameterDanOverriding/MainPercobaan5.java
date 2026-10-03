package TugasPraktikum6.Percobaan5KonstruktorBerparameterDanOverriding;

public class MainPercobaan5 {
    public static void main(String[] args) {
        Desktop desk = new Desktop("Dell", 2050, 3200, "Cannon");
        Laptop laptop = new Laptop("Asus", 4090, 2400, 1440);

        desk.showInfo();
        System.out.println();
        laptop.showInfo();
        System.out.println();
        desk.nyalakanKomputer();
    }
}

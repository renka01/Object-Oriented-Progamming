package TugasPraktikum4.Percobaan6DepedencyUSESa;

public class MainPercobaan6 {
    public static void main(String[] args) {
        Laptop laptop = new Laptop("Lenovo LOQ");
        Printer printer = new Printer("EPSON");
        laptop.cetakDokumen(printer, "laporan.pdf");

        
    }
}

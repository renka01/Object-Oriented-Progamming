package TugasPraktikum6.TugasMandiri.Tugas2;

public class TelevisiModern extends Televisi {
    private String modeTampilan;
    private String dvd;
    
    public TelevisiModern(String merk, int jumlahChannel){
        super(merk,jumlahChannel);
        this.modeTampilan = "LED";
        this.dvd = "Kosong";
    }
    public void gantiModusTampilan(String mode){
        this.modeTampilan = mode;
    }
    public void masukkanDVD(String judul){
        this.dvd = judul;
    }
    public void mainkanDVD(){
        if(dvd.equals("Kosong")){
            System.out.println("Sedang memainkan DVD: " + dvd);
        } else {
            System.out.println("Memutar Film : " + dvd + " dengan mode tampilan " + modeTampilan);
        }
    }
    

}

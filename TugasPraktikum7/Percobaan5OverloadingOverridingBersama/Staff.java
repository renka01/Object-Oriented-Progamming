package TugasPraktikum7.Percobaan5OverloadingOverridingBersama;

public class Staff extends Karyawan {
    private  int jamLembur;
    private double tarifLembur;

    public Staff(String nip, String nama, String golongan, int jamLembur, double tarifLembur){
        super(nip, nama, golongan);
        this.jamLembur = jamLembur;
        this.tarifLembur = tarifLembur;
    }
    //OVERLOADING
    public double getGaji(int jamLembur, double tarifLembur){
        return super.getGaji() + jamLembur * tarifLembur;
    }
    
    //OVERRIDING
    @Override
    public double getGaji(){
        return getGaji(jamLembur, tarifLembur);
    }

    @Override 
    public void lihatInfo(){
        super.lihatInfo();
        System.out.println("Jam Lembur: " + jamLembur);
        System.out.println("Tarif/Jam : " + tarifLembur);
    }
}

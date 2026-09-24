package TugasPraktikum4.Percobaan1Agregasi1ke1;



public class Laptop {
    private String merk;
    private Processor proc;

    public Laptop(){

    }

    public Laptop (String merk, Processor proc){
        this.merk = merk;
        this.proc = proc;
    }
    public void setMerk(String merk){
        this.merk = merk;
    }
    
    public String getMerk(){
        return merk;
    }
    public void setProc(Processor proc){
        this.proc = proc;
    }
    public Processor getProc(){
        return proc;
    }
    public void info(){
        System.out.println("Merk Laprop: " + merk);
        proc.info();
    }

}

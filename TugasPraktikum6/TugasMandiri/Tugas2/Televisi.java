package TugasPraktikum6.TugasMandiri.Tugas2;

public class Televisi {
    public String merk;
    public int jumlahChannel;
    private int channelAktif;

    public Televisi(String merk, int jumlahChannel){
        this.merk = merk;
        this.jumlahChannel = jumlahChannel;
        this.channelAktif = 1;
    }
    public void pindahChannel(int channel){
        if(channel >= 1 && channel <= jumlahChannel){
            this.channelAktif = channel;
        }else{
            System.out.println("Channel tidak ditemukan");
        }
    }
    public int getChannelAktif(){
        return channelAktif;
    }
    
}

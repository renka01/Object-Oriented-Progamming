package QUIZ;
//Faren Hafiza Afanda TI-2G
//NIM : 254107020025
//Absen 8
public class MainQuiz {
    public static void main(String[] args){
        Studio studio1 = new Studio("Dragon",150000);
        Operator operator1 = new Operator("Fikri",15000);
        Reservasi reservasi1 = new Reservasi("R-2024-001",3,studio1,operator1);
        System.out.println(studio1.info());
        System.out.println(operator1.info());
        System.out.println("Total Harga : Rp " + reservasi1.hitungTotalHarga(3,3,studio1,operator1));

        
    }
}
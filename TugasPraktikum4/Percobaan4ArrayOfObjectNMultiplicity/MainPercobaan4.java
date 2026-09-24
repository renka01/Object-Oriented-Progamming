package TugasPraktikum4.Percobaan4ArrayOfObjectNMultiplicity;
public class MainPercobaan4 {
    public static void main(String[] args) {
        Penumpang p = new Penumpang("1234", "Mr.Wawan");
        Gerbong gerbong = new Gerbong("A", 10);
        gerbong.setPenumpang(p, 1);
        System.out.println(gerbong.info());

    }
    
}

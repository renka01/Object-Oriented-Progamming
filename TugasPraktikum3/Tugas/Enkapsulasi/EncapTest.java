package TugasPraktikum3.Tugas.Enkapsulasi;

public class EncapTest {
    public static void main(String[] args) {
     EncapDemo encap =  new EncapDemo();
     encap.setName("Super Wawok");
     encap.setAge(35);
     
     System.out.println("Name: " + encap.getName());
     System.out.println("Age: " + encap.getAge());
    }
}

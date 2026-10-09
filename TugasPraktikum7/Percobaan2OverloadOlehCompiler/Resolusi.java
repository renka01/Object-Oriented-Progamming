package TugasPraktikum7.Percobaan2OverloadOlehCompiler;


public class Resolusi {
    public static void tampil(long x){
        System.out.println("tampil(long) : " + x);
    }
    public static void tampil(int x){
        System.out.println("tampil(int)  : " + x);
    }
    public static void tampil(Object x){
        System.out.println("tampil(Object): " + x);
    }
    public static void tampil(int... x){
        System.out.println("tampil(int...): " + x.length + " elemen");
    }
}

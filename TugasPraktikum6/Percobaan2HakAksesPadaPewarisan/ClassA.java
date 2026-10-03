package TugasPraktikum6.Percobaan2HakAksesPadaPewarisan;

public class ClassA {
    private int x;
    private int y;

    public void setX(int x){
        this.x = x;
    }
    public void setY(int y){
        this.y = y;
    }
    public void getNilai(){
        System.out.println("nilai x: " + x);
        System.out.println("nilai y: " + y);
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    
    
}

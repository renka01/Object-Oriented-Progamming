package Percobaan2;
public class Circle {
    private double radius;

    Circle(double radius){
        this.radius = radius;
    }

    double area(){
        return Math.PI * radius * radius;
    }
    
    double circumference(){
        return 2 * Math.PI * radius;
    }
}

package app.Figures;

public class Circle extends Figure {
    Point center;
    double radius;
    Circle(double radius){
        this.radius=radius;
    }
    double area(){
        double a = 3.14*Math.pow(radius,2)/2;
        return a;
    }


}

package app.Figures;

public class Rectangle extends Figure{
    Point a,b;
    Rectangle(Point a, Point b){
        this.a=a;
        this.b=b;
    }
    double area(){
        return ((b.x-a.x)*(b.y-a.y));
    }


}

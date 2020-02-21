package app.Figures;

public class Triangle extends Figure {
    Point a;
    Point b;
    Point c;
    Triangle(Point a, Point b, Point c){
        this.a=a;
        this.b=b;
        this.c=c;
    }

    double area(){
        double length1=Math.sqrt(Math.pow(b.x-a.x,2)+Math.pow(b.y-a.y,2));
        double length2=Math.sqrt(Math.pow(c.x-a.x,2)+Math.pow(c.y-a.y,2));
        double length3=Math.sqrt(Math.pow(c.x-b.x,2)+Math.pow(c.y-b.y,2));
        double p = (length1+length2+length3)/2;
        return Math.sqrt(p*(p-length1)*(p-length2)*(p-length3));
    }


}

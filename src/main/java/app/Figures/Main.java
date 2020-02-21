package app.Figures;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList <Figure> figures = new ArrayList<>();
        Point p1 = new Point(2,3);
        Point p2 = new Point(6,7);
        Point p3 = new Point(5,2);
        Rectangle r = new Rectangle(p1,p2);
        Circle c = new Circle(12);
        Triangle t=new Triangle(p1,p2,p3);
        figures.add(r);
        figures.add(t);
        figures.add(c);
        Double total = 0.0;
        for (Figure f: figures)
            total+=f.area();
        System.out.println(total);
    }
}

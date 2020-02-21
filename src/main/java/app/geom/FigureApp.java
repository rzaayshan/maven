package app.geom;

import java.util.ArrayList;

public class FigureApp {
  static Figure createFigure(){
    switch ((int) Math.random()*3){
      case 0: return new Triangle(createPoint(),createPoint(),createPoint());
      case 1: return new Rectangle(createPoint(),createPoint());
      case 2: return new Circle(createPoint(),(int)(Math.random()*30-15));
      default:
        return null;
    }}

    static Point createPoint(){
      int x = (int)(Math.random()*30-15);
      int y = (int)(Math.random()*30-15);
      Point randomPoint = new Point(x,y);
      return randomPoint;
  }


  public static void main(String[] args) {
    Triangle tr = new Triangle(new Point(6,1), new Point(2,3), new Point(4,5));
    Rectangle rt = new Rectangle(new Point(2,6), new Point(9,3));
    Circle cr = new Circle(new Point(3,1),8);

    ArrayList<Figure> figures = new ArrayList<>();
    figures.add(tr);
    figures.add(rt);
    figures.add(cr);
    for(int i=0;i<5;i++){
      figures.add(createFigure());
    }
    int total = 0;
    for (Figure f: figures) {
      total += f.area();
    }
    System.out.printf("The total area is %d\n", total);

  }

}

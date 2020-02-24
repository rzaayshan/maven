package app.Figures.geom;

public class Rectangle extends Figure {
  Point pt1;
  Point pt2;

  public Rectangle(Point pt1, Point pt2) {
    this.pt1 = pt1;
    this.pt2 = pt2;
  }

  public static Rectangle rand() {
    return new Rectangle(Point.rand(), Point.rand());
  }

  @Override
  public int area() {
    return Math.abs(pt1.x-pt2.x)*(pt1.y-pt2.y);
  }

  public String toString(){
    return (String.format("Rectangle: {Points : %s, %s}", pt1.toString(),pt2.toString()));
  }
}

package app.Figures.geom;

public class Circle extends Figure {
  Point center;
  int radius;

  public Circle(Point center, int radius) {
    this.center=center;
    this.radius=radius;
  }

  public static Circle rand() {
    return new Circle(Point.rand(), Fn.rand());
  }

  @Override
  public int area() {
    return (int)(Math.PI * radius * radius);
  }

  public String toString(){
    return (String.format("Circle: {Center : %s, Radius %d}", center.toString(), radius ));
  }
}

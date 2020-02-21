package app.geom;

public class Circle extends Figure {
  Point center;
  int radius;

  public Circle(Point center, int radius) {
    this.center=center;
    this.radius=radius;
  }

  @Override
  public int area() {
    return (int)(Math.PI * radius * radius);
  }
}

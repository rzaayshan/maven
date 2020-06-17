package warmup;

import lombok.Data;

@Data
class Rectangle {
  private final Point p1;
  private final Point p2;

  static Rectangle random() {
    return new Rectangle(Point.random(), Point.random());
  }

  Rectangle(Point p1, Point p2) {
    this.p1 = p1;
    this.p2 = p2;
  }

}

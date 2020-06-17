package warmup;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Pair<A,B>{
  private final A a;
  private final B b;

  Pair(A a, B b) {
    this.a = a;
    this.b = b;
  }
}

class Rectangles {
  private final List<Rectangle> rectangles;

  static List<Rectangle> random(int qty) {
    return Stream
        .generate(Rectangle::random)
        .limit(qty)
        .collect(Collectors.toList());
  }

  Rectangles() {
    this(C.RECTANGLES_COUNT);
  }

  Rectangles(int qty) {
    this.rectangles = Rectangles.random(qty);
  }

  long area() {
//    int sum= rectangles.stream().mapToInt(r->
//            Math.abs((r.getP1().x()-r.getP2().x())*(r.getP1().y()-r.getP2().y())))
//            .sum();
//
//    for(int i=0;i<rectangles.size()-1;i++){
//      Rectangle r1 = rectangles.get(i);
//      for(int j=i+1;j<rectangles.size();j++){
//        Rectangle r2 = rectangles.get(j);
//        if(r2.getP1().x()>Math.min(r1.getP1().x(),r1.getP2().x())
//          &&r2.getP1().x()<Math.max(r1.getP1().x(),r1.getP2().x())
//          && r2.getP1().y()>Math.min(r1.getP1().y(),r1.getP2().y())
//          && r2.getP1().y()<Math.max(r1.getP1().x(),r1.getP2().y()))
//          sum=sum-Math.abs((r2.getP1().x()-Math.min(r2.getP2().x(),r1.getP2().x()))
//          *(r2.getP1().y()-Math.min(r2.getP2().y(),r1.getP2().y())));
//      }
//    }

    Set<Point> coors = new HashSet<>();
    rectangles.forEach(r->{
      int minX=Math.min(r.getP1().x(),r.getP2().x());
      int maxX=Math.max(r.getP1().x(),r.getP2().x());
      IntStream.rangeClosed(minX,maxX).forEach(x->{
        int minY=Math.min(r.getP1().y(),r.getP2().y());
        int maxY=Math.max(r.getP1().y(),r.getP2().y());
        IntStream.rangeClosed(minY,maxY).forEach(y->
                coors.add(new Point(x,y)));
      });
    });
    return coors.size();

  }

  public Collection<Rectangle> list() {
    return rectangles;
  }
}

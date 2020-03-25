package app.lesson22a4.warmup;

public class XLinkedListApp {
  public static void main(String[] args) {
    XLinkedList xl = new XLinkedList();
    XLinkedList xl2 = new XLinkedList();
    xl.prepend(1); // LL: 1
    xl.prepend(2); // LL: 2,1
    xl.prepend3(3); // LL: 3,2,1
    xl.append(10);   // LL: 3,2,1,10
    xl.append(20);   // LL: 3,2,1,10,20
    xl2.append(12);
    xl2.append(21);
    System.out.println(xl.represent());
    System.out.println(xl.represent2());
    System.out.println(xl.represent3r());
    System.out.println(xl.size());
    System.out.println(xl.sizer());
    System.out.println(xl.contains(20));
    System.out.println(xl.containsr(25));
    xl.merge(xl2.head);
    System.out.println(xl.represent3r());
    System.out.println(xl.containsAt(1,2));
    xl.deleteHead();
    System.out.println(xl.represent3r());
    xl.deleteTail();
    System.out.println(xl.represent3r());
    xl.deleteAt(2);
    System.out.println(xl.represent3r());
    xl.deleteValue(20);
    System.out.println(xl.represent3r());
    xl.insertAfter(2,72);
    System.out.println(xl.represent3r());
    xl.insertBefore(0,13);
    System.out.println(xl.represent3r());

  }
}

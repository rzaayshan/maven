package app.Formatter;

public class FormatterApp {
  public static void print(String s, Formatter f) {

    System.out.println(f.formatter(s));

  }
  public static void main(String[] args) {
    Formatter fmt1 = new Formatter1();
    Formatter fmt2 = new Formatter2();
    Formatter fmt3 = new Formatter3();
    System.out.println("First task");
    print("hello", fmt1); // hello
    print("hello", fmt2); // HELLO
    print("hello", fmt3); // ***********
                            // *  HELLO  *
                            // ***********

    System.out.println("Second task");
    fmt1.print("hello");    // hello
    fmt2.print("hello");    // HELLO
    fmt3.print("hello");

    System.out.println("Third task");
    System.out.println(new Formatter1("hello")); // hello
    System.out.println(new Formatter2("hello")); // HELLO
    System.out.println(new Formatter3("hello")); // ***********
  }
}

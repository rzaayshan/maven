package app.Formatter;

public abstract class Formatter {
    String s;
    abstract void formatter(String s);
    void print(String s){
        System.out.println(this.s);
    }
}

package app.Formatter;

public abstract class Formatter {
    String s;
    abstract String formatter(String s);
    void print(String s){
        this.s=formatter(s);
        System.out.println(this.s);
    }
    Formatter(){

    }
    Formatter(String s){
        this.s=s;
    }
    @Override
    public String toString() {
        return String.format("%s",formatter(s));
    }
}

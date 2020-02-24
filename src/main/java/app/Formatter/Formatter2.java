package app.Formatter;

public class Formatter2 extends Formatter{
    String formatter(String s){
        this.s=s.toUpperCase();
        return this.s;
    }
    Formatter2(){

    }
    Formatter2(String s){
        super(s);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

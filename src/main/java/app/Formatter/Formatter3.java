package app.Formatter;

public class Formatter3 extends Formatter{
    String formatter(String s){
        this.s=String.format("*******\n*%s*\n*******",s.toUpperCase());
        return this.s;
    }
    Formatter3(){

    }
    Formatter3(String s){
        super(s);
    }

    @Override
    public String toString() {
        return super.toString();
    }

}

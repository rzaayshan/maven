package app.Formatter;

public class Formatter3 extends Formatter{
    String formatter(String s){
        this.s="*";
        for(int i=0;i<s.length()+1;i++)
            this.s+="*";
        this.s+="\n*";
        this.s+=s.toUpperCase();
        this.s+="*\n";
        for(int i=0;i<s.length()+2;i++)
            this.s+="*";
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

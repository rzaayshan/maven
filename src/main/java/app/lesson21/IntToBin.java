package app.lesson21;

public class IntToBin {
    public static void main(String[] args) {
        int value = 18;
        StringBuilder bin = new StringBuilder();
        for(int i=0;i<8;i++){
            /*String c = Integer.toString(value%2);
            bin.append(c);
            value=value/2;*/
            bin.append(value&1);
            value = value >> 1;
        }


        System.out.println(bin); // "00010010"
        System.out.println(value>>2);
    }
}

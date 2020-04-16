package lesson;


import java.util.ArrayList;
import java.util.Arrays;

public class StringOp {
    public static String shift(String orig, int toLeft, int toRight) {
        Character[] shiftedLeft = new Character[orig.length()];
        Character[] shiftedRight = new Character[orig.length()];
        int lenght = orig.length();
        for(int i=0;i<orig.length();i++){
            int shiftLeft=i-toLeft;
            if(shiftLeft>=0){
                shiftedLeft[shiftLeft]=orig.charAt(i);
            }
            else{
                shiftedLeft[shiftLeft+lenght]=orig.charAt(i);
            }
        }
        for(int i=0;i<orig.length();i++){
            int shiftRight = i+toRight;
            if(shiftRight<lenght)
                shiftedRight[shiftRight]=shiftedLeft[i];
            else
                shiftedRight[shiftRight-lenght]=shiftedLeft[i];

        }
        return Arrays.toString(shiftedRight);
    }

    public static void main(String[] args) {
        System.out.println(shift("abcd",2,0));
    }
}


public class Brackets {
    public static int calc(String origin) {
        int i,k,max=0;
        for(i=0;i<origin.length();i++){
            k=0;
            while(String.valueOf(origin.charAt(i)).equals("(")){
                k++;
                i++;
            }
            if(k>max)
                max=k;}
        //throw new RuntimeException("should be implemented");
            return max;

    }


}


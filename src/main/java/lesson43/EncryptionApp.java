package lesson43;

public class EncryptionApp {
  public static String encryption(final String s) {
    String s1 = s;
    int len = s1.length();
    int row = (int) Math.sqrt(len);
    int col = row+1;
    if(row*col<len)
      row+=1;
    char [][] tab = new char [row][col];
    int k=0;
    boolean flag = false;
    for(int i=0;i<row;i++) {
      for (int j = 0; j < col; j++) {
        if(k>=len){
          flag=true;
          break;
        }

        tab[i][j] = s.charAt(k++);
      }
      if(flag)
        break;
    }
    StringBuilder res = new StringBuilder();
    for(int i=0;i<col;i++) {
      for (int j = 0; j < row; j++) {
        char c=tab[j][i];
        if(c!=' ')
          res.append(tab[j][i]);
      }
      if(i!=col-1)
        res.append(" ");
    }
    return res.toString();
  }

  public static void main(String[] args) {
    System.out.println(encryption("feedthedog"));
  }
}

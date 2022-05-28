import java.util.Arrays;

public class Lc6083Contest79CheckIfnumberequaldigitr {
    public static void main(String[] args) {

    }

    public boolean digitCount(String num) {

        int[] ary = new int[10];
        Arrays.fill(ary,0);

        for(int i=0; i<num.length(); i++){
            ary[Character.getNumericValue(num.charAt(i))] +=1;
        }

        for(int i=0; i<num.length(); i++){
            if(ary[i]!=Character.getNumericValue(num.charAt(i))){
                return false;
            }
        }



        return true;
    }
}

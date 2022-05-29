import java.util.HashMap;

public class Lc18RomantoInt {
    public static void main(String[] args) {

    }

    public int romanToInt(String s) {
        HashMap<Character, Integer> mp = new HashMap<>();

        mp.put('I', 1);
        mp.put('V',  5);
        mp.put('X', 10);
        mp.put('L', 50);
        mp.put('C', 100);
        mp.put('D', 500);
        mp.put('M',1000);

        int sum = 0;
        for(int i=0; i<s.length(); i++){
            if(i<s.length()-1 && mp.get(s.charAt(i)) < mp.get(s.charAt(i+1))){
                sum += mp.get(s.charAt(i+1)) - mp.get(s.charAt(i));
                i++;
            }else{
                sum += mp.get(s.charAt(i));
            }
        }

        return sum;
    }
}

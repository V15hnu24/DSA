import java.util.HashMap;
import java.util.Stack;

public class Lc20ValidParenthesis {
    public static void main(String[] args) {

    }
    public boolean isValid(String s) {
        if(s.length() % 2 !=0) return false;

        Stack<Character> st = new Stack<>();
        for(char c: s.toCharArray()){
            if(c=='(' || c=='[' || c=='{'){
                st.push(c);
            }
            else if(c==')' && !st.isEmpty() && st.peek() == '('){
                st.pop();
            }
            else if(c=='}' && !st.isEmpty() && st.peek() == '{'){
                st.pop();
            }
            else if(c==']' && !st.isEmpty() && st.peek() == '['){
                st.pop();
            }else{
                return false;
            }
        }

        return st.isEmpty();
/*
        HashMap<Character, Character> mp = new HashMap<>();
        mp.put('(',')');
        mp.put('{','}');
        mp.put('[',']');

        for(int i=0; i<s.length(); i++){
            if(mp.containsKey(s.charAt(i))){
                st.add(s.charAt(i));
            }else{
                if(st.size() > 0 && mp.get(st.peek()) == s.charAt(i)){
                    st.pop();
                }else{
                    return false;
                }
            }
        }

        return (st.size()==0);
        */
    }
}

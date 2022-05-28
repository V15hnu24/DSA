import java.util.HashMap;

public class LC6084Contest79SenderWithlargestcount {
    public static void main(String[] args) {

    }
    public String largestWordCount(String[] messages, String[] senders) {
        String ans = "";
        int max = 0;
        HashMap<String, Integer> mp = new HashMap<>();

        for(int i=0; i<messages.length; i++){
            int len = 0;

            for(int j = 0; j<messages[i].length(); j++){
                if(messages[i].charAt(j) == 32){
                    len++;
                }
            }
            len++;
            if(mp.containsKey(senders[i])){
                mp.put(senders[i], mp.get(senders[i])+ len);
            }else{
                mp.put(senders[i], len);
            }
        }


        for(String s: mp.keySet()){
            if(max < mp.get(s)){
                max = mp.get(s);
                ans = s;
            }else if(max == mp.get(s)){
                System.out.println(ans.compareTo(s));
                if(ans.compareTo(s) < 0){

                    ans = s;
                }
            }
        }

        return ans;

    }
}

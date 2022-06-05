public class LC338CountingBits {
    public static void main(String[] args) {

    }

    public int[] countBits(int n) {
        int[] ans = new int[n+1];
        int hp = 1;

        for(int i = 1; i<n+1; i++){
            if(hp*2 == i){
                hp = i;
            }

            ans[i] = 1 + ans[i - hp];
        }

        return ans;
    }
}

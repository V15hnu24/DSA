public class leetcode70Climbingstairs {
    public static void main(String[] args) {

    }
    // Back to front approach. we come from n to 0. One states that the possible ways from 0 to n. At any other k th stage it says possible ways from k to n.
    public int climbStairs(int n) {
        int one = 1;
        int two = 1;
        for(int i =0; i<n-1; i++){
            int temp = one;
            one = one + two;
            two = temp;
        }

        return one;
    }
}

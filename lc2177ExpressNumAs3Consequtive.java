public class lc2177ExpressNumAs3Consequtive {
    public static void main(String[] args) {

    }
    public long[] sumOfThree(long num) {
        long ans[] = new long[3];

        if((num-6)%3==0){
            ans[0] = (num-6)/3+1;
            ans[1] = (num-6)/3+2;
            ans[2] = (num-6)/3+3;
        }else{
            long ary[] = new long[0];
            return ary;
        }

        return ans;
    }
}

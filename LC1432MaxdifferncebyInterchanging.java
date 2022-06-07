public class LC1432MaxdifferncebyInterchanging {
    public static void main(String[] args) {
        System.out.println(Math.log(10));
    }

    public static int maxDiff(int num) {
        String s = Integer.toString(num);
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for(int i=0; i<=9; i++){
            for(int j=0; j<=9; j++){
                String k = s.replaceAll(Integer.toString(i),Integer.toString(j));
                System.out.println("k == " + k);
                if (k.charAt(0) == '0'){
                    continue;
                }
                if (Integer.parseInt(k) == 0){
                    continue;
                }
                min = Math.min(Integer.parseInt(k),min);
                max = Math.max(Integer.parseInt(k),max);
            }
        }

        return max -min;
    }
}

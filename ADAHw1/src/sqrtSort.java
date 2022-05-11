public class sqrtSort {
    static int sqrtCalls;
    public static void main(String[] args) {
        int[] ary = new int[]{16, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        int n = ary.length;
        for (int v = 0; v < n/(Math.sqrt(n)-1); v++){
            for (int k = 0; k <= n - Math.sqrt(n); k++) {
                sqrtSort(ary, k);
            }

            for (int i = 0; i < n; i++) {
                System.out.print(ary[i] + " ");
            }
            System.out.println();
        }
        System.out.println(sqrtCalls);
    }

    static void sqrtSort(int[] ary, int k){
        sqrtCalls++;
        for (int i = k; i < k +Math.sqrt(ary.length) ; i++) {
            for (int j = i+1; j < k +Math.sqrt(ary.length); j++) {
                if (ary[j] < ary[i]){
                    swap(ary,i,j);
                }
            }
        }
    }

    static void swap(int[] ary, int i, int j) {
        int temp = ary[i];
        ary[i] = ary[j];
        ary[j] = temp;
    }

}
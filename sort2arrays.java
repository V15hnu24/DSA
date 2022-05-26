import java.util.Arrays;

public class sort2arrays {
    public static void main(String[] args) {
        int[] a = new int[]{1,3,5,6,8,0,0,0};
        int[] b = new int[]{0,2,10};

        merge(a,b);

        System.out.println(Arrays.toString(a));
    }

    // This function merges two arrays into one
    static void merge(int[] a, int[] b){
        int[] temp = new int[a.length-b.length];

        for (int i = 0; i < temp.length; i++) {
            temp[i] = a[i];
        }

        int start_b = 0; // Staring index of b
        int start_a = 0; // Starting index of a
        int i = 0; // index of resultant array

        while(start_a<temp.length && start_b<b.length){
            if (temp[start_a] <= b[start_b]){
                a[i] = temp[start_a];
                start_a++;
            }else{
                a[i] = b[start_b];
                start_b++;
            }

            i++;
        }

        // Remaining elements would fill into a from a
        while (start_a < temp.length){
            a[i] = temp[start_a];
            start_a++;
            i++;
        }

        // Remaining elements would fill into a from b
        while(start_b < b.length){
            a[i] = b[start_b];
            start_b++;
            i++;
        }
    }
}
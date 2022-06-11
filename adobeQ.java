import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class adobeQ {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        for (int i = 0; i < n; i++) {
            int l = s.nextInt();
            int r = s.nextInt();
            int ans = 0;
            for (int j = l; j <=r; j++) {
                for (int k = l; k <=r; k++) {
                    if (k*k>=j && isPerfectSquare(2*(k*k-j))){
                        ans++;
                    }
                }

            }
            System.out.println(ans);
        }

    }

    static boolean isPerfectSquare(int x)
    {
        if (x >= 0) {
            int sr = (int)Math.sqrt(x);
            return ((sr * sr) == x);
        }
        return false;
    }
}

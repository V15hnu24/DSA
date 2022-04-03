import java.util.*;

public class therace_hard_ADACodingAssign {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        int[] x = new int[n];
        int[] y = new int[n];
        List<Point> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Point p = new Point();
            p.x = s.nextInt();
            p.y = s.nextInt();
            list.add(p);
        }

        ClosestPairofPoints c = new ClosestPairofPoints();
        c.mindistance(list);

        Point p1 = c.p1;
        Point p2 = c.p2;

        Point p = new Point();
        double min = Double.MAX_VALUE;
        for (int i = 0; i < list.size(); i++) {
            if ((p2.x == list.get(i).x && p2.y == list.get(i).y) || (p1.x == list.get(i).x && p1.y == list.get(i).y)){
                continue;
            }

            if(getDistance(p1,list.get(i)) < min){
                p.x = list.get(i).x;
                p.y = list.get(i).y;
                min = getDistance(p1,list.get(i));
            }
        }

        Point q = new Point();
        for (int i = 0; i < list.size(); i++) {
            if ((p2.x == list.get(i).x && p2.y == list.get(i).y) || (p1.x == list.get(i).x && p1.y == list.get(i).y)){
                continue;
            }

            if(getDistance(p2,list.get(i)) < min){
                q.x = list.get(i).x;
                q.y = list.get(i).y;
                min = getDistance(p2,list.get(i));
            }
        }
        HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();

        if(getDistance(p1,p2) + getDistance(p1,p) + getDistance(p2,p) < getDistance(p1,p2) + getDistance(p1,q) + getDistance(p2,q)){

        }
    }
    static double getDistance(Point a, Point b){
        int x = a.x-b.x;
        int y = a.y-b.y;
        return Math.sqrt(x*x+y*y);
    }
}

class Point {
    int x;
    int y;
    public Point(){
        this.x = 0;
        this.y = 0;
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
class ClosestPairofPoints {
    static double min = Integer.MAX_VALUE;
    static Point p1 =null ,p2 = null;

    private static double getMin(){
        return min;
    }

    public static void mindistance(List<Point> list) throws IllegalArgumentException{
        if(list==null || list.size()<2) throw new IllegalArgumentException("We need atleast 2 points");
        for(int i=0;i<list.size();i++) {
            if(list.get(i)==null)
                throw new IllegalArgumentException("Point is not initialised");
        }
        int n = list.size();
        Point[] SortedByX = new Point[n];
        for(int i=0;i<n;i++){
            SortedByX[i] = list.get(i);
        }
        Arrays.sort(SortedByX, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                if(o1.x!=o2.x)
                    return o1.x-o2.x;
                else
                    return o1.y-o2.y;
            }
        });
        for(int i=0;i<n-1;i++){
            if(SortedByX[i]==SortedByX[i+1]){
                min = 0;
                p1 = SortedByX[i];
                p2 = SortedByX[i+1];
                break;
            }
        }
        Point[] ByY = new Point[n];
        for (int i = 0; i < n; i++)
            ByY[i] = SortedByX[i];
        Point[] temp = new Point[n];
        closest(SortedByX, ByY, temp, 0, n-1);
    }

    private static double closest(Point[] SortedByX, Point[] ByY, Point[] temp, int lo, int hi) {
        if (hi <= lo) return Double.POSITIVE_INFINITY;
        int mid = lo + (hi - lo) / 2;
        Point median = SortedByX[mid];

        // compute closest pair with both endpoints in left subarray or both in right subarray
        double delta1 = closest(SortedByX, ByY, temp, lo, mid);
        double delta2 = closest(SortedByX, ByY, temp, mid+1, hi);
        double delta = Math.min(delta1, delta2);

        // merge back so that ByY[lo..hi] are sorted by y-coordinate
        merge(ByY, temp, lo, mid, hi);

        // temp[0..m-1] = sequence of points closer than delta, sorted by y-coordinate
        int m = 0;
        for (int i = lo; i <= hi; i++) {
            if (Math.abs(ByY[i].x - median.x) < delta)
                temp[m++] = ByY[i];
        }

        for (int i = 0; i < m; i++) {
            for (int j = i+1; (j < m) && (temp[j].y - temp[i].y < delta); j++) {
                double distance = getDistance(temp[i], temp[j]);
                if (distance < delta) {
                    delta = distance;
                    if (distance < min) {
                        min = delta;
                        p1 = temp[i];
                        p2 = temp[j];
                    }
                }
            }
        }
        return delta;
    }

    private static void merge(Point[] a, Point[] temp, int lo, int mid, int hi) {
        // copy to temp[]
        for (int k = lo; k <= hi; k++) {
            temp[k] = a[k];
        }

        // merge back to a[]
        int i = lo, j = mid+1;
        for (int k = lo; k <= hi; k++) {
            if      (i > mid)              a[k] = temp[j++];
            else if (j > hi)               a[k] = temp[i++];
            else if (less(temp[j], temp[i])) a[k] = temp[j++];
            else                           a[k] = temp[i++];
        }
    }

    private static boolean less(Point v, Point w) {
        return v.x<w.x;
    }

    public static double getDistance(Point a, Point b){
        int x = a.x-b.x;
        int y = a.y-b.y;
        return Math.sqrt(x*x+y*y);
    }
}
import java.util.ArrayList;

public class segment_tree {
    public static void main(String[] args) {

    }

    static void build(ArrayList<Integer> seg, int[] ary, int ind, int low, int high){
        if (low==high){
            seg.add(ind, ary[low]);
            return;
        }

        int mid = (low + high)/2;
        build(seg,ary,(2*ind)+1,low, mid);
        build(seg,ary,(2*ind)+2,mid+1, high);
        seg.add(ind,Math.max(seg.get((2*ind)+1), seg.get((2*ind)+2)));
    }

    static int query(ArrayList<Integer> seg, int[] ary, int ind, int low, int high, int l, int r){
        if (low>=l && high<=r){
            return seg.get(ind);
        }
        if (high>l || low<r){
            return Integer.MIN_VALUE;
        }

        int mid = (low+high)/2;

        int left = query(seg,ary,(2*ind)+1,low,mid,l,r);
        int right= query(seg,ary,(2*ind)+2,mid+1,high,l,r);
        return Math.max(left,right);
    }
}

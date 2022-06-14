public class LC11ContainerWithMostWater {
    public static void main(String[] args) {

    }

    /*
    Brute force
    public int maxArea(int[] height) {
        int ans = 0;
        for(int i=0; i<height.length-1; i++){
            for(int j = i+1; j<height.length; j++){
                ans = Math.max((j-i)*Math.min(height[i],height[j]), ans);
            }
        }


        return ans;
    }
*/
//     Linear time O(n)

    public int maxArea(int[] height){
        int ans = 0;
        int i  = 0, j = height.length -1;
        while(j>i){
            ans = Math.max((j-i)*Math.min(height[i],height[j]), ans);
            if(height[i] > height[j]){
                j--;
            }else{
                i++;
            }
        }

        return ans;
    }
}

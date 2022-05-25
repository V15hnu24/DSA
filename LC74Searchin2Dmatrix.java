public class LC74Searchin2Dmatrix {
    public static void main(String[] args) {
        
    }
    public boolean searchMatrix(int[][] matrix, int target) {

        int s = 0, l = matrix.length -1;

        int mid = 0;
        while(s<=l){
            mid = (s + l)/2;

            if(matrix[mid][matrix[mid].length-1] < target){
                s = mid+1;
            }else if (matrix[mid][0] > target){
                l = mid-1;
            }else{
                break;
            }
        }

        if(!(s<=l)){
            return false;
        }


        s = 0;
        int k = matrix[l].length -1;

        int mid1 = 0;
        while(s<=k){
            mid1 = (s + k)/2;

            if(matrix[mid][mid1] < target){
                s = mid1+1;
            }else if (matrix[mid][mid1] > target){
                k = mid1-1;
            }else if(matrix[mid][mid1] == target){
                return true;
            }
        }

        return false;
    }
}

public class TwoPointer{

    public static boolean twoPointerTechnique(int[] arr, int n, int target){
       
        int low = 0;
        int high = n-1;

        while(low<=high){
            if(arr[low] + arr[high] == target){
                return true;
            }
            else if(arr[low]+arr[high] < target){
                low++;
            }
            else {
                high--;
            }
        }
        return false;
    }
    public static void main(String[] args) {
         // array declaration
        int arr[] = { 2, 3, 5, 8, 9, 10, 11 };
          
        // value to search
        int val = 17;
        
        // size of the array
        int arrSize = arr.length;

        System.out.println(twoPointerTechnique(arr, arrSize, val));
    }
}
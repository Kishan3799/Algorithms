public class SlidingWindowTechnique {
    public static int maxSum(int arr[], int size, int k){
        // size of window is greater than array size
        if(k > size){
            System.out.println("invalid");
            return -1;
        }
        //Sum of first window of size K
        int maxSum = 0;
        for(int i = 0; i < k; i++){
            maxSum += arr[i];
        }

        //Sum of Remaining window
        int windowSum = maxSum;
        for(int i=k; i<size; i++){
            windowSum += arr[i] - arr[i-k];
            if(windowSum > maxSum){
                maxSum = windowSum;
            }
        }

        return maxSum;
    }
    public static void main(String[] args) {
        int arr[] = { 1, 4, 2, 10, 2, 3, 1, 0, 20 };
        int k = 4;//size of window
        int n = arr.length;
        System.out.println(maxSum(arr, n, k));
    }
    
}

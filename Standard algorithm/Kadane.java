public class Kadane {
    //function to find maximum sub array
    // also handle negative numbers array
    public static int kadaneAlgo(int[] arr){
        // storing maximum sub array found so far
        int maxSum = Integer.MIN_VALUE;

        //Storeing the maximum sum of subarry ending at the current position.
        int currSum = 0;

        //Traversing lineraly in give array
        for (int i : arr) {

            currSum = currSum + i;

            // curr is greater than max than 
            // make maxSum as curr
            if(currSum > maxSum)
            {
                maxSum = currSum;
            }

            //if finding any negative element in sub array 
            // then  make curr as 0 and discart the sub array
            if(currSum < 0)
            {
                currSum = 0;
            }

        }

        return maxSum;

    }
    public static void main(String[] args) {
        int[] array = { -8, -3, -6, -2, -5, -4 };

        int result = kadaneAlgo(array);
        System.out.println(result);

    }
}
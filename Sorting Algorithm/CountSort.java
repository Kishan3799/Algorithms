import java.util.Arrays;

public class CountSort {
    public static void countSort(int arr[], int n){
        int output[] = new int[n+1];
        //find max elemnet in array
        int max = arr[0];
        for(int i = 1; i < n; i++ ){
            if(arr[i]>max){
                max = arr[i];
            }
        }

        int[] count = new int[max +1];

        //initialize count array with all zeroes
        for(int i= 0; i<max; ++i){
            count[i] = 0;
        }

        //stroe the count of each element
        for(int i=0; i < n; i++){
            count[arr[i]]++;
        }

        //store the cummulative count  of each array
        for (int i = 1; i <= max; i++) {
            count[i] += count[i-1];
        }

        //find the index of each element of the original array in count array and place the elements  in output array
        for(int i = n-1; i>= 0; i-- ){
            output[count[arr[i]]-1] = arr[i];
            count[arr[i]]--; 
        }

        //copy the sorted elements into original array
        for( int i = 0; i<n; i++){
            arr[i] = output[i];
        }
    }
    public static void main(String[] args) {
        int[] array = {1,3,2,3,4,1,6,4,3};

        int size = array.length;
        countSort(array, size);
        System.out.println(Arrays.toString(array));
    }
}
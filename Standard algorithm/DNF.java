public class DNF {
    
    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void dnfSortAlgo(int arr[], int n){
        int low = 0,mid = 0, high = n-1;

        while(mid<=high){
            if(arr[mid]==0){
                swap(arr,low,mid );
                    low++;
                    mid++;
            }
            else if(arr[mid]== 1){
                mid++;
            }
            else {
                swap(arr,mid,high);
                high--;
            }
        }
    }

    

    public static void main(String[] args) {
        int array[] = {1,0,2,1,0,2,2,1,2};
        int size = array.length;
        dnfSortAlgo(array, size);

        for (int i : array) {
            System.out.print(i + " ");
        }

    }
}

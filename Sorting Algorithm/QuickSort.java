public class QuickSort {
    public static int partition(int arr[] , int low , int high){
       int piviot = arr[high]; //last index
       int i = low-1;
       for(int j= low; j<high; j++){
           if(arr[j]<piviot){
               i++;
               //swap
               int temp = arr[i];
               arr[i]= arr[j];
               arr[j] = temp;
           }
       }
       //swap with piviot
       i++;
       int temp = arr[i];
       arr[i]= arr[high];
       arr[high]= temp;
       return i;
    }
    public static void quickSort(int arr[], int low, int high){
        if(low < high) {
            int piviotIndex = partition(arr,low,high);
            quickSort(arr, low, piviotIndex-1);
            quickSort(arr, piviotIndex+1, high);
        }
    }
    public static void main(String[] args) {
        int myArray[] = {6,3,9,5,2,8};
        int n = myArray.length;
        quickSort(myArray, 0, n-1);

         //print Array 
         for (int i = 0; i < myArray.length; i++) {
            System.out.print(myArray[i]+ " ");
        }
        System.out.println();

    }
}

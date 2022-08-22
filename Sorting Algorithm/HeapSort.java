import java.util.Arrays;

public class HeapSort {
    //Swap function
    public static void swap(int arr[], int i ,  int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
     //Heapify of max heap
    public static void heapify(int arr[], int n , int i){
        int largest = i;
        int l = 2*i;
        int r = 2*i+1;

        if(l < n && arr[largest] < arr[l]) 
            largest = l;

        if(r<n && arr[largest] < arr[r])
            largest = r;
        
        if(largest != i){
            swap(arr, i, largest);
            heapify(arr, n, largest);
        }
    }

    //build heap tree
    public static void buildHeap(int arr[] , int n) {
        for(int i = n/2; i>0; i--){
            heapify(arr, n, i);
        }
    }

    //HeapSort 
    public static void heapSort(int arr[] , int n) {
        for(int i = n-1; i>=1; i--) {
            swap(arr, i, 1);
            heapify(arr, i, 1); 
        }
    }

    public static void main(String[] args) {
        int[] A = {-1,81,89,9,11,14,76,54,22};
        int size = A.length;

        buildHeap(A, size);
        System.out.println("Max heap");
        System.out.println( Arrays.toString(A));
        
        heapSort(A, size);
        System.out.println("After sort");
        System.out.println( Arrays.toString(A));

 
    }
}
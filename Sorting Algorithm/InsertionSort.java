public class InsertionSort {
    public static void printArry(int arr[] , int length){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    // Insertion Sort
    public static void insertionSort(int[] arr){
        int size = arr.length;
        for(int i = 0; i<size; i++ ){
            int current = arr[i];
            int j = i-1;
            while( j>=0 && current < arr[j]){
                arr[j+1] = arr[j];
                j--;
            } 
            //placement 
            arr[j+1] = current;
        }
        printArry(arr , size);
    }
    public static void main(String[] args) {
        int[] arr1 = {7,8,3,1,2};

        insertionSort(arr1);
    }
}

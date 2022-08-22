public class SelectionSort {
    public static void printArry(int arr[] , int length){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    // Selection Sort
    public static void selectionSort(int[] arr){
        int size = arr.length;
        for(int i = 0; i<size -1; i++ ){
            int smallest = i;
            for(int j = i+1; j<size; j++){
                if(arr[smallest] > arr[j]){
                    smallest = j;
                }
            } 
            //swap
            int temp = arr[smallest];
            arr[smallest] = arr[i];
            arr[i] = temp;
        }
        printArry(arr , size);
    }
    public static void main(String[] args) {
        int[] arr1 = {7,8,3,1,2};

        selectionSort(arr1);
    }
}

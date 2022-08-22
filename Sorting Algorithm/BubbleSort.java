public class BubbleSort {
    public static void printArry(int arr[] , int length){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    // Bubble Sort
    public static void bubbleSort(int[] arr){
        int size = arr.length;
        for(int i = 0; i<size -1; i++ ){
            for(int j = 0; j<size-i-1; j++){
                if(arr[j] > arr[j+1]){
                    //swap
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            } 
        }
        printArry(arr , size);
    }
    public static void main(String[] args) {
        int[] arr1 = {7,8,3,1,2};

        bubbleSort(arr1);
    }
}
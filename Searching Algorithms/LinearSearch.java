public class LinearSearch {
    
    static int search(int arr[] , int key) {
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == key) {
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] arr1 = {1,5,4,2,8,9,10, 9};
        
        int ans = search(arr1, 9);
        if(ans == -1) {
            System.out.println("Index not found");
        }
        else{
            System.out.println("Element found at index " + ans );
        }
    }
}
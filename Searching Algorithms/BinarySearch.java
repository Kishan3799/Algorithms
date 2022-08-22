public class BinarySearch {

    //Iterative approch
    public static int binarySearch(int[] arr, int key) {
        int s = 0; //Start index
        int e = arr.length -1;//last index

        while(s<=e)
        {
            int mid = s + (e - s)/2;
            if(arr[mid] == key){
                return mid;
            }
            else if(arr[mid] < key){
                s = mid + 1;
            }
            else{
                e = mid - 1;
            }
        }
        return nums[s] == target?s:-1; // start == end
    }

    //recursive Approch
    public static int binarySearch(int[] arr, int key , int start , int last) {
        if(start> last){
            return -1;
        }
        int mid = start + (last- start)/2;
            if(arr[mid] == key){
                return mid;
            }
            else if(arr[mid] < key){
                return binarySearch(arr, key, mid+1, last);
            }
            else{
                return binarySearch(arr, key, start, mid-1);
            }
    }
    public static void main(String[] args) {
        int Array[] = {10,20,30,40,50,60,70,80};

        int ans = binarySearch(Array,70);
        if(ans == -1 ){
            System.out.println("Index is not present in array");
        }else{
            System.out.println("Index is found at Index " + ans);
        }
    }
}
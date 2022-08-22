import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static int[] intersect(int[] nums1, int[] nums2) {
        if(nums1.length>nums2.length)return intersect(nums2,nums1);
        int[] pre = new int[1001];
        for(int n:nums1)
            pre[n]++; //int this pre element count 
        
         int[] ans = new int[nums1.length];
        int c=0;
        
        for(int n:nums2){
            if(pre[n] != 0){
                ans[c++] = n;
                pre[n]--;
            }
        }
        
        return Arrays.copyOf(ans,c);
        
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int[] ar = new int[nums.length+1];
        for(int i=0;i<nums.length;i++){
            ar[nums[i]]++;
        }
        for(int i=1;i<ar.length;i++){
            if(ar[i] == 0) list.add(i);
        }
        return list;
    }
    public static void main(String[] args) {
        int[] nums1= {1,2,2,1};
        int[] nums2= {2,2};
        int[] nums= {4,3,2,7,8,2,3,1};
        System.out.println(intersect(nums1, nums2));
        System.out.println(findDisappearedNumbers(nums));
        

    }
}

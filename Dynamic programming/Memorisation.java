import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Memorisation {
   
   
    public static void main(String[] args) {
        Map<String,Integer> lookup = new HashMap<>();

        // coin change problem 
        // Make Rs 18 using indian denomination like - 1,2,5,10,20,50,100,200,500,2000
        int n =18;
        int[] a={10,5,2,1};
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        dp[0] = 0;

        int ans = minCoins(n, a, dp);
        System.out.println(ans);

        // 0/1 KnapSack problem 
        int W = 10; // total bag weight
        int[] w = {1,3,4,5};
        int[] v = {20,30,10,50};

    // function 
    //    int ans2 =  knapSack(W,weight,value, value.length-1);
    //    System.out.println("Knapsack value is "+ ans2);

    // Using dp bottom - up approch (Tabulation)
    int ans3 = knapSack1(W,w,v);
    System.out.println("Knapsack value is "+ ans3);
   
    //Using dp  Top - Down approch (memorization)
    System.out.println("Knapsack value is "+  knapSack2(v, w, v.length - 1 , W, lookup));

    }
    // coin change problem using dp
    public static int minCoins(int n, int[] a, int[] dp){
        //base case
        if(n==0)return 0;

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < a.length; i++) {

            if(n-a[i]>=0){
                int subAns = 0;
                if(dp[n-a[i]] != -1){
                    subAns = dp[n-a[i]];
                }else{
                    subAns = minCoins(n-a[i], a,dp);
                }
                if(subAns != Integer.MAX_VALUE && subAns +1 < ans){
                    ans = subAns+1;
                }
            }
        }
        return dp[n] = ans;
    }

    // 0/1 KnapSack problem 
    // Bag capacity is 10kg
    // Item weight and value is 
    // 1kg->20
    // 3kg->30
    // 4kg->10
    // 6kg->50
    // Total number of distinct items `n`
   
   //Using Recursion TC in exponential
    public static int knapSack(int W , int[] weight, int[] value , int n){
        //base case
        // bag capacity is 0 
        if(W < 0)return Integer.MIN_VALUE;

        //no item left or bag weight is 0
        if(n < 0 || W==0)return 0;

        int include = value[n] + knapSack(W -weight[n], weight, value, n-1);
        
        int exclude = knapSack(W, weight, value, n-1);

        return Integer.max(include, exclude);
    }

    //Using DP Top - Down approch (memorization)  TC is O(n.W)
    public static int knapSack2(int[] value, int[] weight , int n, int W, Map<String,Integer> lookup){
        //base case
        // bag capacity is 0 
        if(W < 0)return Integer.MIN_VALUE;

        //no item left or bag weight is 0
        if(n < 0 || W==0)return 0;

        String key = n + "|" + W;

        if(!lookup.containsKey(key)){
            int include = value[n] + knapSack2(value,weight,n-1,W-weight[n], lookup);
            
            int exclude = knapSack2(value,weight,n-1,W,lookup);

            lookup.put(key, Integer.max(include, exclude));
        }

        return lookup.get(key);
    }
    //Using DP Bottom up approch (tabulation)  TC is O(n.W)
    public static int knapSack1(int W, int[] weight, int[] value){
        
        int[][] total = new int[value.length+1][W+1];
        
        for (int i = 1; i <= value.length; i++) {
            for (int j = 0; j <=W; j++) {
                if(weight[i-1] > j){ 
                    total[i][j] = total[i-1][j];
                } else {
                    total[i][j] = Integer.max(total[i-1][j], total[i-1][j-weight[i-1]] + value[i-1]);  
                }
            }
        }

        return total[value.length][W];
    }


}
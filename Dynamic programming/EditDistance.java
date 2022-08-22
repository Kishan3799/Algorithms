import java.util.Arrays;

// minimum number of operation to convert String S1 into s2
// 0perations : Insert , Delete , Replace
// Levenshtein distance 
public class EditDistance {
    public static void main(String[] args) {
        // String s1 = "kitten";
        // String s2 = "sitting";

        // int ans = editDistance(s1, s2, s1.length(), s2.length());
        // int ans = dist(s1, s2);
        // System.out.println("minimum is " + ans);

        // int Rod = 8;
        // int[] price = {1,5,6,9,11,12,14,16};
        
        // int ans2 = cutRod(Rod, price);
        // System.out.println("Maximum profit is "+ ans2);

        int[][] mat =
        {
            { -5, -6, 3, 1, 0 },
            { 9, 7, 8, 3, 7 },
            { -6, -2, -1, 2, -4 },
            { -7, 5, 5, 2, -6 },
            { 3, 2, 9, -5, 1 }

        };

        

        System.out.println("Maximum sum is " + maxSumSubMatrix(5,5,mat));
        


    }   
    //Recursion way
    public static int editDistance(String s1, String s2, int s1_size,  int s2_size){
        if(s1_size == 0 || s2_size == 0){
            return 0;
        }

        if(s1.charAt(s1_size - 1) == s2.charAt(s2_size-1)){
            return editDistance(s1, s2, s1_size-1, s2_size-1);
        }
        return minimum(editDistance(s1, s2, s1_size-1, s2_size) + 1, //deletion
                        editDistance(s1, s2, s1_size, s2_size-1) +1, //insertion
                        editDistance(s1, s2, s1_size-1, s2_size-1) +1 ); //Substitution
    }

    //Utility function
    public static int minimum(int a,int b ,int c){
        return Integer.min(a, Integer.min(b, c));
    }

    // DP - bottom up approch
    public static int dist(String s1, String s2){
        int x = s1.length();
        int y = s2.length();

        int[][] DP = new int[x+1][y+1];

        for (int i = 0; i <=x ; i++) DP[i][0] =i;
        for (int j = 0; j <=y ; j++) DP[0][j] =j;

        for(int i=1; i<=x; i++){
            for (int j = 1; j <= y; j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    DP[i][j] = DP[i-1][j-1];
                }
                else{
                    DP[i][j]= 1 + Math.min(Math.min(DP[i][j-1],DP[i-1][j]), DP[i-1][j-1]);
                }
            }
        }

        return DP[x][y];
    }

    public static int cutRod(int rodLength, int[] price){
        //dp array
        int[] profit = new int[rodLength + 1];

        for (int i = 1; i <=rodLength; i++) {
            for (int j = 0; j < i; j++) {
                profit[i] = Integer.max(profit[i], price[j] + profit[i-j-1]);
            }
        }

        return profit[rodLength];
    }

    // Find maximum sum submatrix present in a matrix
    public static int maxSumSubMatrix(int r,int c, int[][] matrix){
        int[] sum = new int[r];
        int maxSum = Integer.MIN_VALUE;
        for(int cStart = 0;  cStart < c; cStart++){
            Arrays.fill(sum,0);
            for(int cEnd = cStart; cEnd < c; cEnd++){
                for(int row = 0; row<r; row++){
                    sum[row] += matrix[row][cEnd];
                }
                int curMaxSum = kadaneAlgo(sum);
                maxSum = Math.max(maxSum, curMaxSum);
            }
        }
        return maxSum;
    }

    public static int kadaneAlgo(int[] arr){
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;
        for (int i : arr) {
            currSum = currSum + i;
            if(currSum > maxSum)  {
                maxSum = currSum;
            }
            if(currSum < 0) {
                currSum = 0;
            }
        }
        return maxSum;
    }

}

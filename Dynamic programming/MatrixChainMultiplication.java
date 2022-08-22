public class MatrixChainMultiplication {
    public static void main(String[] args) {
    //find minimum operation
    int[] matrix = {2,3,4,1,3};
    int n = matrix.length;

    int ans = matrixChain(n,matrix);
    System.out.println("Mininum no is "+ans);

    //Minimum number of partion  to make palindrome
        String st = "abac";

        int ans2 = minPartion(st);
        System.out.println("Mininum partition is "+ans2);
    }
  
    //find minimum operation
    public static int matrixChain(int n, int[] array) {
        int[][] dp = new int[n][n];
        //diagonally traverse
        for(int len = 2; len<n; len++){
            for(int row=0, col = len; row <n-len; row++ ,col++ ){
                dp[row][col] = Integer.MAX_VALUE;
                for(int k=row+1; k<col; k++){
                    dp[row][col]=Math.min(dp[row][col],
                    dp[row][k] + dp[k][col] + array[row]*array[k]*array[col]);
                }
            }
        
        }
        return dp[0][n-1];
    }

    //Minimum number of partion  to make palindrome
    public static int minPartion( String st) {
        int n = st.length();
        int[][] dp = new int[n][n];
        for(int gap = 1; gap<n; gap++){
            for(int row=0, col = gap; row <n-gap; row++ ,col++ ){
                if(isPalindrome(st,row,col)){
                    dp[row][col]=0;
                }else{
                    dp[row][col] = Integer.MAX_VALUE;
                    for(int k=row; k<col; k++){
                        dp[row][col]=Integer.min(dp[row][col], 
                        1+dp[row][k] + dp[k+1][col]);
                    }
                }
            }
        }
        return dp[0][n-1];
    }

    public static boolean isPalindrome(String st ,int i ,int j){
        while(i<j){
            if(st.charAt(i++) != st.charAt(j--) ) return false;
        }
        return true;
    }
}
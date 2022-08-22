// import java.util.HashMap;
import java.util.Map;

public class DPStringQuestion {
    public static void main(String[] args) {
        String s1 = "ABCBDAD";
        String s2 = "BDCABA";
        int m = s1.length();
        int n = s2.length();

        //2d Matrix
        int[][] dpArray = new int[m+1][n+1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dpArray[i][j] = -1;
            }
        }

        //construct Map
        // Map<String,Integer> lookup = new HashMap<>();

        // System.out.println("Lenth of LCS " + lcs(m, n, s1, s2));
        // System.out.println("Lenth of LCS2 is " + lcs2(m, n, s1, s2,dpArray));
        // System.out.println("Lenth of LCS3 is " + lcs3(m, n, s1, s2,lookup));
        System.out.println("Lenth of LCS bottom up is " + lcsBottomUp(s1,s2));

    }
    // Longest common subSequence (LCS)
    // only Recursion
    // TC in O(2^(m+n))
    public static int lcs (int m, int n, String s1, String s2){
        //String is empty
        // return if the end of either sequence is reached
        if(m == 0 || n == 0){
            return 0;
        }
        if(s1.charAt(m-1) == s2.charAt(n-1)){
            return lcs(m-1, n-1, s1, s2) + 1;
        }
        return Integer.max(lcs(m-1, n, s1, s2), lcs(m, n-1, s1, s2));

    }

    // Using dp 
    // Top - down approch( Memorization )
    // using 2d Array //TC is O(m.n);
    public static int lcs2(int m, int n, String s1, String s2,int[][] dp){
        //String is empty
        // return if the end of either sequence is reached
        if(m == 0 || n == 0){
            return 0;
        }
        if(dp[m][n] != -1){
            return dp[m][n];
        }
        if(s1.charAt(m-1) == s2.charAt(n-1)){
            return dp[m][n] = lcs2(m-1,n-1, s1, s2,dp) + 1;
        }
        return dp[m][n] = Integer.max(lcs2(m-1, n, s1, s2,dp), lcs2(m, n-1, s1, s2,dp));
    }

    // Using dp 
    // Top - down approch( Memorization )
    // using 2d Array 
    //TC is O(m.n);
    public static int lcs3(int m, int n, String s1, String s2,Map<String, Integer> lookUp){
        //String is empty
        // return if the end of either sequence is reached
        if(m == 0 || n == 0){
            return 0;
        }
        // construct a unique map key from dynamic elements of the input
        String key = m + "|" + n;
        if(!lookUp.containsKey(key)){  
            if(s1.charAt(m-1) == s2.charAt(n-1)){
                lookUp.put(key, lcs3(m-1,n-1, s1, s2,lookUp) + 1);
            }
            else{
                lookUp.put(key, Integer.max(lcs3(m-1, n, s1, s2,lookUp), lcs3(m, n-1, s1, s2,lookUp))); 
            }
        }
        return lookUp.get(key);
    }

    // Using dp 
    // Bottom-up approch( Memorization )
    // using 2d Array 
    public static int lcsBottomUp(String s1,String s2){
        int M=s1.length(), N=s2.length();
        int[][] LCS = new int[M+1][N+1];

        for (int i = 1; i <=M; i++) {
            for (int j = 1; j<=N; j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    LCS[i][j]= LCS[i-1][j-1] + 1;
                }
                else {
                    LCS[i][j]= Integer.max(LCS[i-1][j], LCS[i][j-1]);
                }
            }
        }

        return LCS[M][N];
    }



}

package DP;
import java.util.*;
public class LongestCommonSubstring {
    public static void main(String args[]){
        System.out.println(longestCommonSubstring("abkde", "abcde"));
    }
    private static int longestCommonSubstring(String S1,String S2){
        int dp[][] = new int[S1.length()+1][S2.length()+1];
        for(int i=0;i<S1.length()+1;i++){
            Arrays.fill(dp[i],0);
        }
        int max=0;
        for(int i=1;i<=S1.length();i++){
            for(int j=1;j<=S2.length();j++){
                if(S1.charAt(i-1)==S2.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                    max=Math.max(dp[i][j],max);
                }
                else{
                    dp[i][j]=0;
                }
            }
        }
        return dp[S1.length()][S2.length()];
    }
}

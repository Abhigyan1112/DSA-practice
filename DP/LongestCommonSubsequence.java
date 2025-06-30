package DP;
import java.util.*;
public class LongestCommonSubsequence extends Solution{
    
}

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[] prev=new int[text2.length()+1];
        Arrays.fill(prev,0);
        for(int i1=1;i1<=text1.length();i1++){
            int[] curr=new int[text2.length()+1];
            for(int i2=1;i2<=text2.length();i2++){
                if(text1.charAt(i1-1)==text2.charAt(i2-1)){
                    curr[i2]= 1 + prev[i2-1];
                }
                else curr[i2]=Math.max(prev[i2],curr[i2-1]);
            }
            prev=curr;
        }
        return prev[text2.length()];
    }

    // //To print the longest Common Subsequence
    // private String printlongestCommonSubsequence(int[][] dp,String text1, String text2){
    //     int i1=dp.length;
    //     int i2=dp[0].length;
    //     StringBuffer string=new StringBuffer();
    //     while(i1>0 && i2>0){
    //         if(text1.charAt(i1-1)==text2.charAt(i2=1)){
    //             string.setCharAt(0,text1.charAt(i1-1));
    //             i1--;
    //             i2--;
    //         }
    //         else if(dp[i1][i2-1]>dp[i1-1][i2]){
    //             i2--;
    //         }
    //         else{
    //             i1--;
    //         }
    //     }
    //     return string.toString();
    // }

    // private int helper(int i1,int i2, String text1, String text2,int[][] dp){
    //     if(i1==0 || i2==0) return 0;
    //     if(dp[i1][i2]!=-1) return dp[i1][i2];
    //     if(text1.charAt(i1-1)==text2.charAt(i2-1)){
    //         return dp[i1][i2]= 1 + helper(i1-1,i2-1,text1,text2,dp);
    //     }
    //     return dp[i1][i2]=Math.max(helper(i1-1,i2,text1,text2,dp),helper(i1,i2-1,text1,text2,dp));
    // }
}
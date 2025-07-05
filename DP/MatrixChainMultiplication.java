package DP;
import java.util.* ;

public class MatrixChainMultiplication {
    public static void main(String[] args) {
        
    }
}

class Solution {
	public static int matrixMultiplication(int[] arr , int N) {
		int[][] dp=new int[N][N];
		for(int i=0;i<N;i++){
			Arrays.fill(dp[i],-1);
		}
		return helper(1,N-1,arr,dp);
	}
	private static int helper(int i, int j,int[] arr,int[][] dp){
		if(i==j) return 0;
		if(dp[i][j]!=-1) return dp[i][j];
		int min=Integer.MAX_VALUE;
		for(int k=i;k<j;k++){
			min=Math.min(min,arr[i-1]*arr[k]*arr[j]+helper(i,k,arr,dp)+helper(k+1,j,arr,dp));
		}
		return dp[i][j]=min;
	}
}

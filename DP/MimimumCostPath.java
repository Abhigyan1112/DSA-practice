package DP;
class Solution{
    public static int minSumPath(int[][] grid) {
        int N=grid.length;
        int M=grid[0].length;
        int[] prevRow=new int[M];
        for(int i=0;i<N;i++){
            int[] currRow=new int[M];
            for(int j=0;j<M;j++){
                if(i==0 && j==0) currRow[j]=grid[i][j];
                else{
                    int top=Integer.MAX_VALUE;
                    int left=Integer.MAX_VALUE;
                    if(i>0) top=prevRow[j];
                    if(j>0) left=currRow[j-1];
                    currRow[j]=grid[i][j]+Math.min(top,left);
                }
            }
            prevRow=currRow;
        }
        return prevRow[M-1];
    }
}
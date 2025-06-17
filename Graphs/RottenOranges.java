import java.util.*;
class Solution
{
    int[] delrow={-1,0,1,0};
    int[] delcol={0,-1,0,1};
    class Pair{
        int row,col,time;
        Pair(int row,int col,int time){
            this.row=row; this.col=col; this.time=time;
        }
    }
    //Function to find minimum time required to rot all oranges.  
    public int orangesRotting(int[][] grid)
    {
        int n=grid.length;
        int m=grid[0].length;
        int countFresh=0;
        Queue<Pair> q=new LinkedList<Pair>();
        int[][] vis=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    q.add(new Pair(i,j,0));
                    vis[i][j]=1;
                }
                else{
                    vis[i][j]=0;
                }
                if(grid[i][j]==1) countFresh++;
            }
        }
        int time=0;
        int count=0;
        while(!q.isEmpty()){
            int r=q.peek().row;
            int c=q.peek().col;
            int t=q.peek().time;
            time=Math.max(time,t);
            q.poll();
            for(int i=0;i<4;i++){
                int row=delrow[i]+r;
                int col=delcol[i]+c;
                if(row>=0 && row<n && col>=0 && col<m && vis[row][col]==0 && grid[row][col]==1){
                    q.add(new Pair(row,col,t+1));
                    vis[row][col]=1;
                    count++;
                }
            }
        }
        if(count!=countFresh) return -1;
        return time;
    }
}
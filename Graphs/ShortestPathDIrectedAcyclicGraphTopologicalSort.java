import java.util.*;
public class ShortestPathDIrectedAcyclicGraphTopologicalSort extends Solution{
    public static void main(String args[]){

    }
}
// User function Template for Java
class Solution {
    class Pair{
        int pointer;
        int weight;
        Pair(int pointer,int weight){
            this.pointer=pointer;
            this.weight=weight;
        }
    }
    public int[] shortestPath(int V, int E, int[][] edges) {
        ArrayList<ArrayList<Pair>> adj=new ArrayList<ArrayList<Pair>>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<Pair>());
        }
        for(int[] edge: edges){
            adj.get(edge[0]).add(new Pair(edge[1],edge[2]));
        }
        Stack<Integer> stack=new Stack<Integer>();
        boolean vis[]=new boolean[V];
        for(int i=0;i<V;i++){
            if(!vis[i]) dfs(i,stack,adj,vis);
        }
        int[] ans=new int[V];
        Arrays.fill(ans,Integer.MAX_VALUE);
        ans[0]=0;
        while(!stack.isEmpty()){
            int top=stack.pop();
            if(ans[top]!=Integer.MAX_VALUE)
            for(Pair neigh: adj.get(top)){
                ans[neigh.pointer]=Math.min(ans[neigh.pointer],ans[top]+neigh.weight);
            }
            else ans[top]=-1;
        }
        return ans;
    }
    private void dfs(int node,Stack<Integer> stack,ArrayList<ArrayList<Pair>> adj,boolean[] vis){
        vis[node]=true;
        for(Pair neigh: adj.get(node)){
            if(!vis[neigh.pointer]) dfs(neigh.pointer,stack,adj,vis);
        }
        stack.push(node);
    }
}

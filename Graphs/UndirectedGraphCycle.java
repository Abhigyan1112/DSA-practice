import java.util.*;
public class UndirectedGraphCycle extends Solution{
    public static void main(String args[]){

    }
}
class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(ArrayList<ArrayList<Integer>> adj) {
        for(int i=0;i<adj.size();i++){
            boolean[] vis=new boolean[adj.size()];
            vis[i]=true;
            if(dfs(adj,vis,i,-1)) return true;
        }
        return false;
    }
    private boolean dfs(ArrayList<ArrayList<Integer>> adj,boolean[] vis,int node,int parent){
        for(int neighbour : adj.get(node)){
            if(neighbour!=parent){
                if(vis[neighbour]) return true;
                vis[neighbour]=true;
                if(dfs(adj,vis,neighbour,node)) return true;
            }
        }
        return false;
    }
}


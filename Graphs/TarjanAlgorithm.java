import java.util.*;
public class TarjanAlgorithm extends Solution{
    
}

// This alogrithm is used to find bridges in a graph.
// A bridge in a graph is defined as an edge which when removed will seperate the two ends into two different components.

class Solution {
    int timer=1;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<Integer>());
        }
        for(List<Integer> connection : connections){
            adj.get(connection.get(0)).add(connection.get(1));
            adj.get(connection.get(1)).add(connection.get(0));
        }
        boolean[] vis = new boolean[n];
        int[] timeOfInsertion = new int[n];
        int[] lowestTime = new int[n];
        List<List<Integer>> bridges =new ArrayList<>();
        dfs(0,-1,adj,vis,timeOfInsertion,lowestTime,bridges);
        return bridges;
    }
    private void dfs(int node, int parent, ArrayList<ArrayList<Integer>> adj, boolean[] vis, 
                    int[] tin, int[] low, List<List<Integer>> bridges){
        vis[node]=true;
        tin[node]=low[node]=timer;
        timer++;
        for(int neigh: adj.get(node)){
            if(neigh==parent) continue;
            if(!vis[neigh]){
                dfs(neigh,node,adj,vis,tin,low,bridges);
                low[node]=Math.min(low[neigh],low[node]);
                if(low[neigh]>tin[node]){
                    bridges.add(Arrays.asList(neigh,node));
                }
            }
            else{
                low[node]=Math.min(low[neigh],low[node]);
            }
        }
    }
}
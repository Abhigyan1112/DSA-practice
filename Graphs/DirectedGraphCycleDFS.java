import java.util.*;
public class DirectedGraphCycleDFS extends Solution{
    public static void main(String args[]){
    }
}
class Solution {
    public boolean isCyclic(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> list=new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<V;i++){
            list.add(new ArrayList<Integer>());
        }
        for(int[] edge: edges){
            list.get(edge[0]).add(edge[1]);
        }
        boolean[] vis=new boolean[V];
        boolean[] pathVis=new boolean[V];
        for(int i=0;i<V;i++){
            if(!vis[i]){
                if(dfs(i,list,vis,pathVis)) return true;
            }
        }
        return false;
    }
    private boolean dfs(int start,ArrayList<ArrayList<Integer>> list,boolean[] vis,boolean[] pathVis){
        vis[start]=true;
        pathVis[start]=true;
        for(int node:list.get(start)){
            if(pathVis[node]) return true;
            if(!vis[node]){
                if(dfs(node,list,vis,pathVis)) return true;
            }
        }
        pathVis[start]=false;
        return false;
    }
}


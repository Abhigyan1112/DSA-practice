import java.util.*;
public class TopologicalSort {
    public static void main(String args[]){
        //only for directed acyclic graphs.
        //Arranges the nodes in an order such that which node is before which one.
        //Uses a Stack
    }
}
class Solution {
    public static ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
        boolean[] vis=new boolean[V];
        ArrayList<ArrayList<Integer>> adj=new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<Integer>());
        }
        for(int[] edge:edges){
            adj.get(edge[0]).add(edge[1]);
        }
        ArrayList<Integer> ans=new ArrayList<>();
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<V;i++){
            if(!vis[i]) dfs(i,adj,stack,vis);
        }
        while(!stack.isEmpty()){
            ans.add(stack.pop());
        }
        return ans;
    }
    private static void dfs(int node,ArrayList<ArrayList<Integer>> adj,Stack<Integer> stack, boolean[] vis){
        vis[node]=true;
        for(int neighbour: adj.get(node)){
            if(!vis[neighbour]) dfs(neighbour,adj,stack,vis);
        }
        stack.push(node);
    }
}
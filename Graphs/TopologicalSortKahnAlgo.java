import java.util.*;
public class TopologicalSortKahnAlgo extends Solution{
    public static void main(String args[]){

    }
}
// Topological Sort using BFS
class Solution {
    public static ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
        int[] topo=new int[V];
        ArrayList<ArrayList<Integer>> adj=new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> ans=new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<Integer>());
        }
        for(int[] edge:edges){
            adj.get(edge[0]).add(edge[1]);
            topo[edge[1]]++;
        }
        Queue<Integer> queue=new LinkedList<>();
        for(int i=0;i<V;i++){
           if(topo[i]==0) queue.add(i);
        }
        while(!queue.isEmpty()){
            int node=queue.poll();
            ans.add(node);
            for(int neighbour:adj.get(node)){
                if(--topo[neighbour]==0) queue.add(neighbour);
            }
        }
        return ans;
    }
}
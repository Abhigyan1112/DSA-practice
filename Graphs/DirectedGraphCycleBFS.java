import java.util.*;
public class DirectedGraphCycleBFS {
    public static void main(String args[]){
        
    }
}
class Solution {
    public boolean isCyclic(int V, int[][] edges) {
        int[] topo=new int[V];
        ArrayList<ArrayList<Integer>> adj=new ArrayList<ArrayList<Integer>>();
        int ans=0;
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
            ans++;
            for(int neighbour:adj.get(node)){
                if(--topo[neighbour]==0) queue.add(neighbour);
            }
        }
        return !(ans==V);
    }
}


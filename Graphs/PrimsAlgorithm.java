import java.util.*;
public class PrimsAlgorithm extends Solution{
    public static void main(String[] args) {
        
    }
}
class Solution {
    static class Pair{
        int node;
        int dist;
        Pair(int node, int dist){
            this.node=node;
            this.dist=dist;
        }
    }
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        // Code Here.
        PriorityQueue<Pair> queue=new PriorityQueue<Pair>((a,b)->a.dist-b.dist);
        queue.add(new Pair(0,0));
        boolean[] vis=new boolean[V];
        int ans=0;
        while(!queue.isEmpty()){
            Pair top=queue.poll();
            if(vis[top.node]) continue;
            ans+=top.dist;
            vis[top.node]=true;
            for(int[] neigh: adj.get(top.node)){
                if(!vis[neigh[0]]){
                    queue.add(new Pair(neigh[0],neigh[1]));
                }
            }
        }
        return ans;
    }
}


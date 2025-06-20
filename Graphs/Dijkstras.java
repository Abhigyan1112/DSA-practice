import java.util.*;
public class Dijkstras extends Solution{
    public static void main(String[] args) {
        
    }
}
// Can be done with PriorityQueue, Queue or Set, Set also stores in ascending order.
class Solution {
    class Pair{
        int node;
        int dist;
        Pair(int node,int dist){
            this.node=node;
            this.dist=dist;
        }
    }
    public int[] dijkstra(int V, int[][] edges, int src) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<ArrayList<Pair>>();
        PriorityQueue<Pair> queue=new PriorityQueue<Pair>((x,y) -> x.dist-y.dist);
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<Pair>());
        }
        for(int i=0;i<edges.length;i++){
            adj.get(edges[i][0]).add(new Pair(edges[i][1],edges[i][2]));
        }
        int[] min=new int[V];
        Arrays.fill(min,Integer.MAX_VALUE);
        min[src]=0;
        queue.add(new Pair(src,0));
        while(!queue.isEmpty()){
            Pair temp=queue.poll();
            for(Pair neigh : adj.get(temp.node)){
                if(min[neigh.node]>temp.dist+neigh.dist){
                    min[neigh.node]=temp.dist+neigh.dist;
                    queue.add(new Pair(neigh.node,min[neigh.node]));
                }
            }
        }
        return min;
    }
}
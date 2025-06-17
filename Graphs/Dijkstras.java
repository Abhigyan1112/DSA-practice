
import java.util.*;
class Dijkstras
{
    //Function to find the shortest distance of all the vertices
    //from the source vertex S.
    static class Pair{
        int node,distance;
        Pair(int node,int distance){
            this.node=node;
            this.distance=distance;
        }
    }
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        PriorityQueue<Pair> queue=new PriorityQueue<>((a,b) -> a.distance-b.distance);
        
        int dist[]=new int[V];
        Arrays.fill(dist,Integer.MAX_VALUE);
        queue.add(new Pair(S,0));
        dist[S]=0;
        while(!queue.isEmpty()){
            int distance=queue.peek().distance;
            int node=queue.peek().node;
            int length=adj.get(node).size();
            queue.poll();
            for(int i=0;i<length;i++){
                int adjNode=adj.get(node).get(i).get(0);
                int edge=adj.get(node).get(i).get(1);
                if(distance+edge<dist[adjNode]){
                    dist[adjNode]=distance+edge;
                    queue.add(new Pair(adjNode,dist[adjNode]));
                }
            }
        }
        return dist;
    }
}
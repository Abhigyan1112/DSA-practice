import java.util.*;
public class ShortestPathUndirectedGraphBFS extends Solution {
    public static void main(String args[]){
    }
}
class Solution {
    class Pair{
        int pointer;
        int dist;
        Pair(int pointer,int dist){
            this.pointer=pointer;
            this.dist=dist;
        }
    }
    // Function to find the shortest path from a source node to all other nodes
    public int[] shortestPath(ArrayList<ArrayList<Integer>> adj, int src) {
        Queue<Pair> queue=new LinkedList();
        int[] ans=new int[adj.size()];
        Arrays.fill(ans,Integer.MAX_VALUE);
        ans[src]=0;
        queue.add(new Pair(src,0));
        while(!queue.isEmpty()){
            Pair start=queue.poll();
            for(int node: adj.get(start.pointer)){
                if(ans[node]>start.dist+1){
                    ans[node]=start.dist+1;
                    queue.add(new Pair(node,ans[node]));
                }
            }
        }
        for(int i=0;i<adj.size();i++){
            if(ans[i]==Integer.MAX_VALUE) ans[i]=-1;
        }
        return ans;
    }
}


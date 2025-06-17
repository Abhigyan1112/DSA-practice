import java.util.*;
class Solution {
    public boolean isBipartite(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> edge=new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<V;i++){
            edge.add(new ArrayList<Integer>());
        }
        for(int[] e:edges){
            edge.get(e[0]).add(e[1]);
            edge.get(e[1]).add(e[0]);
        }
        int[] color=new int[V];
        for(int i=0;i<V;i++){
            if(color[i]==0){
                color[i]=1;
                if(!dfs(i,1,edge,color)) return false;
            }
        }
        return true;
    }
    private boolean dfs(int start,int parentColor,ArrayList<ArrayList<Integer>> edges,int[] color){
        for(int node: edges.get(start)){
            if(parentColor==color[node]) return false;
            if(color[node]==0){
                color[node]=parentColor==1?2:1;
                if(!dfs(node,color[node],edges,color)) return false; 
            }
        }
        return true;
    }
}
public class Bipartite extends Solution{
    public static void main(String args[]){}
}
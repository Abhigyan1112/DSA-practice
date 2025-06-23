// helps to detect negative cycles
import java.util.*;
public class BellmanFord extends Solution{
    public static void main(String[] args) {
        
    }
}
// User function Template for Java
// iterate over all edges n-1 times and keep updating the minimum cost array, if the array changes for the nth time, negative cycle is present

class Solution {
    public int[] bellmanFord(int V, int[][] edges, int src) {
        // code here
        int[] min=new int[V];
        int mod=(int)Math.pow(10,8);
        Arrays.fill(min,mod);
        min[src]=0;
        for(int i=1;i<V;i++){
            for(int[] edge:edges){
                if(min[edge[0]]!=mod && min[edge[0]]+edge[2]<min[edge[1]]){
                    min[edge[1]]=min[edge[0]]+edge[2];
                }
            }
        }
        for(int[] edge:edges){
            if(min[edge[0]]!=mod && min[edge[0]]+edge[2]<min[edge[1]]){
                int[] temp={-1};
                return temp;
            }
        }
        return min;
    }
}

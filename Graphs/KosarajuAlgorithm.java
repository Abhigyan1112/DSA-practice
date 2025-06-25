import java.util.*;
public class KosarajuAlgorithm {
    public static void main(String[] args) {
        
    }
}

// A Strongly connected component is when every pair of vertices of the component are reachable starting from one another.
// The algorithm of Kosaraju has the following steps.
// 1) Take a stack and apply dfs on the graph so that the node which was first traversed is on the top(adding node at the end of the dfs function to the stack)
// 2) reverse all the edges of the graph in a new adjacency list.
// 3) one by one take out nodes from the stack, if they are not visited mark them as visited and call dfs for the node. All the node connected will be marked visited.
// The number of nodes found not visited are the number of strongly connected components.
// The idea is that if you reverse the nodes the scc will still traverse through all its nodes but the edges connecting different scc(s) will not work in the start to end direction.
// So when dfs is called all the nodes of the scc containing the called node are marked but it does not jump to another scc.

class Solution {
    // Function to find number of strongly connected components in the graph.
    public int kosaraju(ArrayList<ArrayList<Integer>> adj) {
        // code here
        Stack<Integer> stack = new Stack<>();
        boolean vis[]=new boolean[adj.size()];
        for(int i=0;i<adj.size();i++){
            if(!vis[i]) dfs(adj,vis,i,stack);
        }
        ArrayList<ArrayList<Integer>> reverseAdj=new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<adj.size();i++){
            reverseAdj.add(new ArrayList<Integer>());
        }
        for(int i=0;i<adj.size();i++){
            for(int node: adj.get(i)){
                reverseAdj.get(node).add(i);
            }
        }
        int ans=0;
        Arrays.fill(vis,false);
        while(!stack.isEmpty()){
            int top=stack.pop();
            if(!vis[top]){
                ans++;
                dfs(reverseAdj,vis,top);
            }
        }
        return ans;
    }
    private void dfs(ArrayList<ArrayList<Integer>> adj, boolean[] vis, int node, Stack<Integer> stack){
        vis[node]=true;
        for(int neigh: adj.get(node)){
            if(!vis[neigh]){
                dfs(adj,vis,neigh,stack);
            }
        }
        stack.push(node);
    }
    private void dfs(ArrayList<ArrayList<Integer>> adj, boolean[] vis, int node){
        vis[node]=true;
        for(int neigh: adj.get(node)){
            if(!vis[neigh]){
                dfs(adj,vis,neigh);
            }
        }
    }
    
}
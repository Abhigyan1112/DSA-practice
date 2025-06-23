
// To find out if two nodes lets say 1 and 5 belong to the same component(are connected through anyway), you would need to do a graph traversal
// graph traversal, either bfs or dfs takes O(E+V) time
// DisjointSet can say a YES or NO to that in constant time.
// Used in dynamic graphs(graphs which keep on changing)
// Two options - 1) Finding the parent  2)Union - (a) Rank (b) Size
// Time complexity on Union is with Rank is O(4*alpha) constant.

class DisjointSet{
    public static void main(String[] args) {
        // DisjointSetUnionRank set=new DisjointSetUnionRank(7);
        // set.unionByRank(1,2);
        // set.unionByRank(2,3);
        // set.unionByRank(4,5);
        // set.unionByRank(6,7);
        // set.unionByRank(5,6);
        // if(set.findUltimateParent(3)==set.findUltimateParent(7)){
        //     System.out.println("same");
        // }
        // else{
        //     System.out.println("Not Same");
        // }
        // set.unionByRank(3, 7);
        // if(set.findUltimateParent(3)==set.findUltimateParent(7)){
        //     System.out.println("same");
        // }
        // else{
        //     System.out.println("Not Same");
        // }
        DisjointSetUnionSize s=new DisjointSetUnionSize(7);
        s.unionBySize(1,2);
        s.unionBySize(2,3);
        s.unionBySize(4,5);
        s.unionBySize(6,7);
        s.unionBySize(5,6);
        if(s.findUltimateParent(3)==s.findUltimateParent(7)){
            System.out.println("same");
        }
        else{
            System.out.println("Not Same");
        }
        s.unionBySize(3, 7);
        if(s.findUltimateParent(3)==s.findUltimateParent(7)){
            System.out.println("same");
        }
        else{
            System.out.println("Not Same");
        }
    }
}

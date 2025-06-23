import java.util.ArrayList;

public class DisjointSetUnionRank extends DisjointSet{
    ArrayList<Integer> rank = new ArrayList<>();
    ArrayList<Integer> parent = new ArrayList<>();
    public DisjointSetUnionRank(int n){
        for(int i=0;i<n+1;i++){
            rank.add(0);
            parent.add(i);
        }
    }
    public int findUltimateParent(int node){
        if(node==parent.get(node)) return node;
        parent.set(node,findUltimateParent(parent.get(node)));
        return parent.get(node);
    }
    public void unionByRank(int u,int v){
        int UltimateParentOfU=findUltimateParent(u);
        int UltimateParentOfV=findUltimateParent(v);
        if(UltimateParentOfU==UltimateParentOfV) return;
        if(rank.get(UltimateParentOfU)<rank.get(UltimateParentOfV)){
            parent.set(UltimateParentOfU,UltimateParentOfV);
        }
        else if(rank.get(UltimateParentOfU)>rank.get(UltimateParentOfV)){
            parent.set(UltimateParentOfV,UltimateParentOfU);
        }
        else{
            parent.set(UltimateParentOfV,UltimateParentOfU);
            rank.set(UltimateParentOfU,rank.get(UltimateParentOfU)+1);
        }
    }
}




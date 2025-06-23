import java.util.ArrayList;

public class DisjointSetUnionSize extends DisjointSet{
    ArrayList<Integer> size = new ArrayList<>();
    ArrayList<Integer> parent = new ArrayList<>();
    DisjointSetUnionSize(int n){
        for(int i=0;i<n+1;i++){
            size.add(1);
            parent.add(i);
        }
    }
    public int findUltimateParent(int node){
        if(node==parent.get(node)) return node;
        parent.set(node,findUltimateParent(parent.get(node)));
        return parent.get(node);
    }
    public void unionBySize(int u,int v){
        int UltimateParentOfU=findUltimateParent(u);
        int UltimateParentOfV=findUltimateParent(v);
        if(UltimateParentOfU==UltimateParentOfV) return;
        if(size.get(UltimateParentOfU)<size.get(UltimateParentOfV)){
            parent.set(UltimateParentOfU,UltimateParentOfV);
            size.set(UltimateParentOfV,size.get(UltimateParentOfU)+size.get(UltimateParentOfV));
        }
        else{
            parent.set(UltimateParentOfV,UltimateParentOfU);
            size.set(UltimateParentOfU,size.get(UltimateParentOfU)+size.get(UltimateParentOfV));
        }
    }
}

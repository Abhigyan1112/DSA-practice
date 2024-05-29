package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS extends BinarySearchTree{
    public List<List<Integer>> breadthsearch(){
        List<List<Integer>> ans=new ArrayList<>();
        if(root==null){
            return ans;
        }
        Queue<Node> queue=new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int levelSize=queue.size();
            List<Integer> currentlist=new ArrayList<>(levelSize);
            for(int i=0;i<levelSize;i++){
                Node currentNode=queue.poll();
                currentlist.add(currentNode.value);
                if(currentNode.left!=null){
                    queue.add(currentNode.left);
                }
                if(currentNode.right!=null){
                    queue.add(currentNode.right);
                }
            }
            ans.add(currentlist);
        }
        return ans;
    }
}

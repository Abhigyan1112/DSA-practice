package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS extends BinarySearchTree{
    public List<List<Integer>> breadthsearch(){
        List<List<Integer>> ans=new ArrayList<>();  //creating a list of lists to store the nodes at every level
        if(root==null){
            return ans;
        }
        Queue<Node> queue=new LinkedList<>();   //Breadth First search uses a queue to store the children of the current node and the pass the current node
        queue.add(root);    //first add the root node as it is not child to any node
        while(!queue.isEmpty()){
            int levelSize=queue.size(); // at every level, the size of the queue would be equal to the number of nodes at that level
            List<Integer> currentlist=new ArrayList<>(levelSize);   
            for(int i=0;i<levelSize;i++){
                Node currentNode=queue.poll();  
                currentlist.add(currentNode.value);    //adds the nodes of the current node to the current list
                if(currentNode.left!=null){
                    queue.add(currentNode.left);
                }
                if(currentNode.right!=null){
                    queue.add(currentNode.right);   
                }                                       //adds the children of the current node to the queue
            }
            ans.add(currentlist);      //after completion of every level, adds the nodes of the level(the list) to the answer list
        }
        return ans;
    }
    public Node findSuccessNode(int key){
        if(root==null){
            return null;
        }
        Queue<Node> queue=new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            Node curNode=queue.poll();
            if(curNode.left!=null) queue.add(curNode.left);
            if(curNode.right!=null) queue.add(curNode.right);
            if(curNode.value==key){
                return queue.poll();
            }
        }
        return null;
    }
}

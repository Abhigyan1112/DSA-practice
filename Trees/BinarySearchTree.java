package Trees;

public class BinarySearchTree {
    public class Node{
        public int height;
        public int value;
        public Node right;
        public Node left;

        Node(int value){
            this.value=value;
        }
    }
    public Node root;
    public int height(Node node){
        if(node==null){
            return -1;
        }
        return node.height;
    }
    public void insert(int value){
        root= insert(value,root);
    }
    public void populate(int[] nums){
        for(int i=0;i<nums.length;i++){
            insert(nums[i]);
        }
    }
    public void populatedSorted(int[] nums){
        populatedSorted(nums,0,nums.length);
    }
    private void populatedSorted(int[] nums,int start,int end){
        if(start>=end){
            return;
        }
        int mid=(start+(end-start)/2);
        insert(nums[mid]);
        populatedSorted(nums,start,mid);
        populatedSorted(nums,mid+1,nums.length);
    }
    private Node insert(int value,Node node){
        if(node==null){
            node=new Node(value);
            return node;
        }
        if(value<node.value){
            node.left=insert(value,node.left);
        }
        if(value>node.value){
            node.right=insert(value,node.right);
        }
        node.height=Math.max(height(node.left),height(node.right))+1;
        return node;
    }
    public boolean balanced(){  //to check if the tree is balanced or not
        return balanced(root);
    }
    public boolean balanced(Node node){
        if(node==null){
            return true;
        }
        return Math.abs(height(node.left)-height(node.right))<=1 && balanced(node.left) && balanced(node.right);
    }
    public void display(){
        display(root, "The root node is: ");
    }
    public void display(Node node,String add){
        if(node==null){
            return;
        }
        System.out.println(add+node.value);
        display(node.left,"The left child of "+node.value+" is: ");
        display(node.right,"The right child of "+node.value+" is: ");
    }
    public void buildTree(int[] preorder, int[] inorder) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buildTree'");
    }
}

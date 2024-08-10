package Trees;

public class AVLTree {
    public class Node{
        private int height;
        private int value;
        private Node right;
        private Node left;

        Node(int value){
            this.value=value;
        }
    }
    private Node root;


    public int height(Node node){
        if(node==null){
            return -1;
        }
        return node.height;
    }


    public void insert(int value){
        root= insert(value,root);
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
        return rotate(node);
    }

    private Node rotate(Node node){
        if(node.left.height-node.right.height>1){   //left heavy
            if(node.left.left.height>node.left.right.height){   //case 1(left-left case)
                return rightrotate(node);
            }
            if(node.left.left.height<node.left.right.height){   //case 2(left-right case)
                node.left=leftrotate(node.left);
                return rightrotate(node);
            }
        }
        if(node.left.height-node.right.height<1){   //right heavy
            if(node.left.left.height<node.left.right.height){   //case 1(right-right case)
                return leftrotate(node);
            }
            if(node.left.left.height>node.left.right.height){   //case 2(right-left case)
                node.right=rightrotate(node.right);
                return leftrotate(node);
            }
        }
        return node;
    }
    private Node rightrotate(Node p){
        Node c=p.left;
        Node t2=c.right;
        c.right=p;
        p.left=t2;

        p.height=Math.max(p.left.height,p.right.height);
        c.height=Math.max(c.left.height,c.right.height);
        return c;
    }
    private Node leftrotate(Node c){
        Node p=c.right;
        Node t2=p.left;
        p.left=c;
        c.right=t2;

        c.height=Math.max(c.left.height,c.right.height);
        p.height=Math.max(p.left.height,p.right.height);
        return p;
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
}

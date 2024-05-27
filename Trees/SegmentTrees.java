package Trees;

public class SegmentTrees {     
    //Segment Tree is a special type of full binary tree which contains an interval in which the operation is to be performed and the value of performing the operation on that interval

    private static class Node{
        int data;   //contains the value of the operation
        Node left;  //left Node
        Node right; //right Node
        int startInterval;  //the start index of the interval
        int endInterval;    //the end index of the interval
        
        
        private Node(int startInterval,int endInterval){    //contstructor for the Tree
            this.startInterval=startInterval;
            this.endInterval=endInterval;
        }
    }

    public static void main(String args[]){
        int[] arr={3,8,6,7,-2,-8,4,9};      //array to convert to tree
        SegmentTrees tree=new SegmentTrees();
        tree.arrayToTree(arr);
        tree.display();
    }


    Node root;

    public void arrayToTree(int[] arr){     //takes an array as arguements and then constructs a tree from its values
        this.root=constructTree(arr,0,arr.length-1);
    }


    public Node constructTree(int arr[],int start,int end){
        if(start==end){     //the leaf index has been reached,put the value in it
            Node leaf=new Node(start,end);
            leaf.data=arr[start];
            return leaf;
        }
        Node node=new Node(start,end);  //make a node for the current index

        int mid=start+(end-start)/2;    

        node.left=constructTree(arr,start,mid);     //call for the left node
        node.right=constructTree(arr,mid+1,end);    //call for the right node

        node.data=node.left.data+node.right.data;   //intialize the value of the node
        return node;                                //return the node
    }

    public int findQuery(int start,int end){    //helper function to find the sum between a specific interval
        return query(root,start,end);       
    }
    private int query(Node node,int start,int end){
        if(node.startInterval>=start && node.endInterval<=end){
            //node is completely inside the interval
            return node.data;
        }
        else if(start>node.endInterval || end<node.startInterval){
            //node is completely outside the interval
            return 0;
        }
        else{
            return query(node.left,start,end)+query(node.right,start,end);
        }
    }

    //update
    public void update(int index,int value){
        this.root.data=update(this.root,index,value);
    }
    private int update(Node node,int index, int value){
        if(index>=node.startInterval && index<=node.endInterval){
            if(index==node.startInterval && index==node.endInterval){
                node.data=value;
                return node.data;
            }
            else{
                int leftAns=update(node.left,index,value);
                int rightAns=update(node.right,index,value);

                node.data=leftAns + rightAns;
                return node.data;
            }
        }
        return node.data;
    }


    public void display(){
        display(root);
    }
    private void display(Node node){
        String str="";

        if(node.left != null){
            str=str+"Interval=["+node.left.startInterval + "-" + node.left.endInterval + "] and data: " + node.left.data + "=> ";
        }
        else{
            str=str+"No left child";
        }

        // for current node
        str=str+"Interval=["+node.startInterval + "-" + node.endInterval + "] and data: " + node.data + "<=";

        if(node.right!=null){
            str=str + "Interval=[" + node.right.startInterval + "-" + node.right.endInterval + "] and data: "+ node.right.data;
        }
        else{
            str=str+"No right child";
        }
        System.out.println(str+ "\n");

        //call recursion
        if(node.left !=null){
            display(node.left);
        }
        if(node.right !=null){
            display(node.right);
        }
    }
}

package Trees;

import java.util.Scanner;

public class BinaryTree{
    private class Node{     // Node class
        Node left;
        Node right;
        int value;
        Node(int value){
            this.value=value;
        }
    }
    private Node root; 

    //to insert items in to the tree
    public void insert(Scanner sc){
        System.out.println("Enter the value of the root node");
        root=new Node(sc.nextInt());
        populate(sc, root);
    }
    private void populate(Scanner sc,Node node){    //to fill tree with as many number of nodes
        System.out.println("Do you want to insert to the left of the node: "+node.value);
        if(sc.nextBoolean()){
            System.out.println("Enter the value");
            node.left=new Node(sc.nextInt());
            populate(sc,node.left);
        }
        System.out.println("Do you want to insert to the right of the node: "+node.value);
        if(sc.nextBoolean()){
            System.out.println("Enter the value");
            node.right=new Node(sc.nextInt());
            populate(sc,node.right);
        }
    }


    public void display(){
        display(root," ");
    }
    private void display(Node node,String indent){  
        if(node==null){
            return;
        }
        System.out.println(indent+node.value);
        display(node.left,indent+"\t");
        display(node.right,indent+"\t");
    }


    public void prettyDisplay(){    //to display the tree in a pretty method
        prettyDisplay(root,0);
    }
    private void prettyDisplay(Node node,int level){
        if(node==null){
            return;
        }
        prettyDisplay(node.right,level+1);
        if(level!=0){
            for(int i=0;i<level-1;i++){
                System.out.print("|\t");
            }
            System.out.println("|------>" + node.value);
        }
        else{
            System.out.println(node.value);
        }
        prettyDisplay(node.left, level+1);
    }


    public void preOrder(){     //Node-Left-Right       print
        preOrder(root);
    }
    public void preOrder(Node node){
        if(node==null){
            return ;
        }
        System.out.print(node.value+" ");
        preOrder(node.left);
        preOrder(node.right);
    }

    public void inOrder(){      //Left-Node-Right       print
        inOrder(root);
    }
    public void inOrder(Node node){
        if(node==null){
            return ;
        }
        inOrder(node.left);
        System.out.print(node.value+" ");
        inOrder(node.right);
    }

    public void postOrder(){        //Left-Right-Node       print
        postOrder(root);
    }
    public void postOrder(Node node){
        if(node==null){
            return ;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.value+" ");
    }
}
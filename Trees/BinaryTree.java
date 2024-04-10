package Trees;

import java.util.Scanner;

public class BinaryTree{
    private class Node{
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
    private void populate(Scanner sc,Node node){
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
    public void prettyDisplay(){
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
}
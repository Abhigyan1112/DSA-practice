package Trees;

import java.util.Scanner;

public class Main {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        BinaryTree BT=new BinaryTree();
        BT.insert(sc);
        BT.prettyDisplay();
        BT.preOrder();
        BT.postOrder();
        BT.inOrder();
        // BinarySearchTree BT=new BinarySearchTree();
        // int[] nums={1,2,3,4,5,6,7,8,9};
        // BT.populatedSorted(nums);
        // BT.display();
    }
}

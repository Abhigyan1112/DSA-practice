package Trees;

import java.util.Scanner;

public class Main {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        BinaryTree BT=new BinaryTree();
        BT.insert(sc);
        BT.prettyDisplay();
    }
}

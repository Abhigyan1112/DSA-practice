import linkedlist.*;
import java.util.Scanner;
public class Main {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        LL list=new LL();
        // int a=sc.nextInt();
        // while(a!=0){
        //     list.Insert(a);
        //     a=sc.nextInt();
        // }
        // list.print();
        // list.DeleteAtIndex(2);
        // list.print();
        // sc.close();
        // DoubleLL list=new DoubleLL();
        // int a=sc.nextInt();
        // while(a!=0){
        //     // list.insertFirst(a);
        //     list.insertEnd(a);
        //     a=sc.nextInt();
        // }
        // list.insertAtIndex(sc.nextInt(), sc.nextInt());
        // list.print();
        // CircularLL list=new CircularLL();
        // list.print();
        // list.delete(sc.nextInt());
        // LL list =new LL();
        // list.Insert(55);
        // list.Insert(45);
        // list.Insert(25);
        // list.Insert(5);
        // list.Insert(15);
        // list.Insert(75);
        // list.print();
        // System.out.println("Enter the value and index");
        // list.insertRec(sc.nextInt(),sc.nextInt());
        // list.print();
        int a=sc.nextInt();
        while(a!=0){
            // list.insertFirst(a);
            list.Insert(a);
            a=sc.nextInt();
        }
        list.reverseTheList();
        list.print();
        sc.close();
    }
}
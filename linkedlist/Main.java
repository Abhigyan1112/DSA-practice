import linkedlist.*;
import java.util.Scanner;
public class Main {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        // LL list=new LL();
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
        CircularLL list=new CircularLL();
        int a=sc.nextInt();
        while(a!=0){
            // list.insertFirst(a);
            list.insertEnd(a);
            a=sc.nextInt();
        }
        list.print();
        list.delete(sc.nextInt());
        sc.close();
    }
}

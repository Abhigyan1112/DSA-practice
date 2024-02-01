package Linkedlist;
import java.util.*;
class LinkedList{
    public static void main(String args[]){
        LinkedList list = new LinkedList();
        Scanner sc=new Scanner(System.in);
        System.out.println(list.head);
        list.Insert(5);
        System.out.println(list.head.data);
        list.Insert(6);
        int val=sc.nextInt();
        while(val!=0){
            list.Insert(val);
            val=sc.nextInt();
        }
        list.print();
        System.out.println("");
        list.removeDuplicate();
        sc.close();
    }
    void Insert(int d){
        Node newnode=new Node(d);
        if(head==null){
            head=newnode;
        }
        else{
            Node temp;
            temp=head;
            while(temp.next!=null){
                temp=temp.next;
            }
            temp.next=newnode;
        }
    }
    void print(){
        Node temp;
        temp=head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
    }
    void removeDuplicate(){
        Node temp;
        temp=head;
        while(temp.next!=null){
            if(temp.data==temp.next.data){
                temp=temp.next;
            }
            else{
                System.out.print(temp.data+" ");
                temp=temp.next;
            }
        }
    }
    Node head;
    Node tail;
    class Node{
        int data;
        Node next;
        Node(int d){
            data=d;
            next=null;
        }
    }
}
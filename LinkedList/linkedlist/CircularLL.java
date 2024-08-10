package linkedlist;

public class CircularLL {
    class Node{
        int data;
        Node next;
        Node(int d){
            data=d;
        }
    }
    Node head;
    Node tail;
    int size=0;
    public void insertEnd(int d){
        size++;
        Node newnode=new Node(d);
        if(head==null){
            head=tail=newnode;
            head.next=tail;
            return;
        }
        newnode.next=head;
        tail.next=newnode;
        tail=newnode;
    }
    public void delete(int d){
        if(head==null) return;
        size--;
        Node temp=head;
        if(temp.data==d){
            head=head.next;
            tail.next=head;
            print();
            return;
        }
        do{
            if(temp.next.data==d){
                temp.next=temp.next.next;
                print();
                return;
            }
            temp=temp.next;
        }while(temp!=head);
        System.out.println("No such element exists");
    }
    public void print(){
        Node temp=head;
        try{
            do{
                System.out.print(temp.data+" -> ");
                temp=temp.next;
            }while(temp!=head);
            System.out.println("HEAD");
        }
        catch(NullPointerException e){
            System.out.println("The list is empty");
        }
    }
}

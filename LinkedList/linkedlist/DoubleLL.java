package linkedlist;

public class DoubleLL {
    class Node{
        int data;
        Node next;
        Node prev;
        Node(int d){
            data=d;
            next=null;
            prev=null;
        }
    }
    Node head;
    Node tail;
    int size=0;
    public void insertFirst(int d){
        size++;
        Node newnode=new Node(d);
        if(head==null){
            head=tail=newnode;
            return; 
        }
        newnode.next=head;
        head.prev=newnode;
        head=newnode;
    }
    public void insertEnd(int d){
        size++;
        Node newnode=new Node(d);
        Node temp=head;
        if(head==null){
            insertFirst(d);
            return;
        }
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=newnode;
        newnode.prev=temp;
        tail=newnode;
    }
    public void insertAtIndex(int index,int d){
        size++;
        if(index==0){
            insertFirst(d);
            return;
        }
        if(index==size){
            insertEnd(d);
            return;
        }
        Node temp=head;
        int i=1;
        while(i<index){
            temp=temp.next;
            i++;
        }
        Node newnode= new Node(d);
        newnode.next=temp.next;
        newnode.prev=temp;
        temp.next.prev=newnode;
        temp.next=newnode;
    }
    public void print(){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+" -> ");
            temp=temp.next;
        }
        System.out.println("END");
    }
}

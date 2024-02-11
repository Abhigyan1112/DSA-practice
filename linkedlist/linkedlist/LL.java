package linkedlist;
public class LL{

    public void Insert(int d){
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
            tail=newnode;
        }
        size++;
    }
    public void InsertFirst(int d){
        Node newnode=new Node(d);
        newnode.next=head;
        head=newnode;
        size++;
    }
    public void print(){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
        System.out.println("");
    }
    public void removeDuplicate(){
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
    public void InsertAtIndex(int pos,int d){
        size++;
        Node temp=head;
        if(pos==0){
            InsertFirst(d);
            return;
        }
        int i=1;
        while(i<pos){
            temp=temp.next;
            i++;
        }
        Node newnode=new Node(d);
        newnode.next=temp.next;
        temp.next=newnode;
    }
    public void DeleteFirst(){
        if(head==null){
            tail=null;
            return;
        }
        head=head.next;
        size--;
        print();
    }
    public void DeleteLast(){
        Node temp=head;
        while(temp.next!=tail){
            temp=temp.next;
        }
        tail=temp;
        temp.next=null;
        size--;
    }
    public void DeleteAtIndex(int i){
        int t=0;
        Node temp=head;
        if(i==0){
            DeleteFirst();
            return;
        }
        while(t<i-1){
            temp=temp.next;
            t++;
        }
        temp.next=temp.next.next;
    }
    public void insertRec(int val,int index){
        head=insertRec(val,index,head);
    }
    private Node insertRec(int value,int index,Node temp){
        if(index==0){
            Node newnode=new Node(value);
            newnode.next=temp;
            size++;
            return newnode;
        }
        temp.next=insertRec(value,index-1,temp.next);
        return temp;
    }
    public void reverseTheList(){
        tail=reverseTheList(head);
        tail.next=null;
    }
    private Node reverseTheList(Node temp){
        if(temp==tail){
            head=temp;
            return temp;
        }
        reverseTheList(temp.next).next=temp;
        return temp;
    }
    Node head;
    Node tail;
    int size=0;
    class Node{
        int data;
        Node next;
        Node(int d){
            data=d;
            next=null;
        }
    }
}
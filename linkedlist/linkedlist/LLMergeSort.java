package linkedlist;

public class LLMergeSort extends LL{
    public void sortList(){
        head=sortList(head);
    }
    public Node sortList(Node head){
        if(head==null || head.next==null) return head;
        Node mid=middleNode(head);
        Node left=sortList(head);
        Node right=sortList(mid);
        return mergeTwoLists(left,right);
    }
    public Node middleNode(Node head) {
        Node fast=head;
        Node slow=head;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        slow.prev.next=null;
        return slow;
    }
    public void print(){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.val+" -> ");
            temp=temp.next;
        }
        System.out.println("END");
    }
    public Node mergeTwoLists(Node list1, Node list2) {
        Node head=null;
        if(list1==null) return list2;
        if(list2==null) return list1;
        if(list1.val<list2.val){
            head=list1;
            list1=list1.next;
        }
        else{
            head=list2;
            list2=list2.next;
        }
        Node temp=head;
        while(list1!=null && list2!=null){
            if(list1.val<list2.val){
                temp.next=list1;
                temp=list1;
                list1=list1.next;
            }
            else{
                temp.next=list2;
                temp=list2;
                list2=list2.next;
            }
        }
        while(list1!=null){
            temp.next=list1;
            temp=list1;
            list1=list1.next;
        }
        while(list2!=null){
            temp.next=list2;
            temp=list2;
            list2=list2.next;
        }
        return head;
    }
    public void insertEnd(int d){
        size++;
        Node newnode=new Node(d);
        Node temp=head;
        if(head==null){
            head=tail=newnode;
            return;
        }
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=newnode;
        newnode.prev=temp;
        tail=newnode;
    }
    class Node{
        int val;
        Node next;
        Node prev;
        Node(int d){
            val=d;
            next=null;
        }
    }
    Node head;
    Node tail;
}


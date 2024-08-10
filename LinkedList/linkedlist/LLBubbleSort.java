package linkedlist;

public class LLBubbleSort extends DoubleLL{
    public void sortList(){
        head=sortList(head);
    }
    private Node sortList(Node head){
        Node temp1=head;
        Node temp2=tail;
        while(temp1!=temp2){
            while(temp1!=temp2){
                if(temp1.data>temp2.data){
                    int temp=temp1.data;
                    temp1.data=temp2.data;
                    temp2.data=temp;
                }
                temp1=temp1.next;
            }
            temp1=head;
            temp2=temp2.prev;
        }
        return head;
    }
}

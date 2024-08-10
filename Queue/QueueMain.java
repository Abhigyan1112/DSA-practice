package Queue;
import java.util.*;

public class QueueMain {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of the queue");
        CustomQueue queue=new CircularQueue(sc.nextInt());
        while(true){
            System.out.println("Enqueue or Dequeue?");
            String ans=sc.next();
            if(ans.equals("Enqueue")){
                System.out.println("Enter 0 to end");
                int a=sc.nextInt();
                while(a!=0){
                    if(!queue.enqueue(a)){
                        System.out.println("Queue is now full");
                        break;
                    }
                    a=sc.nextInt();
                }
            }
            else if(ans.equals("Dequeue")){
                try {System.out.println(queue.dequeue());}
                catch(Exception Exception){
                    System.out.println(Exception);
                }
            }
            else{
                break;
            }
        }
        sc.close();
    }
}

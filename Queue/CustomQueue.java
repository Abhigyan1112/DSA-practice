package Queue;
public class CustomQueue {
    int[] data;
    int end=0;
    public CustomQueue(){
        this(10);
    }
    public CustomQueue(int maxsize){
        this.data=new int[maxsize];
    }
    public boolean isFull(){
        return end==data.length;
    }
    public boolean isEmpty(){
        return end==-0;
    }
    public boolean enqueue(int d){
        if(isFull()){
            return false;
        }
        data[end++]=d;
        return true;
    }
    public int dequeue() throws Exception{
        if(isEmpty()){
            throw new Exception("Queue is Empty");
        }
        int element=data[0];
        // shift all the elements to the left by 1
        for(int i=1;i<end;i++){
            data[i-1]=data[i];
        }
        end--;
        return element;
    }
    public int peek() throws Exception{
        if(isEmpty()){
            throw new Exception("Queue is Empty");
        }
        return data[0];
    }
}

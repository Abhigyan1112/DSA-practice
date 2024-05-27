package Queue;

public class CircularQueue extends CustomQueue{
    int front=0;
    int size=0;
    CircularQueue(){
        super();
    }
    CircularQueue(int d){
        super(d);
    }
    public boolean isFull(){
        return size==data.length;
    }
    public boolean isEmpty(){
        return size==0;
    }
    public boolean enqueue(int d){
        if(isFull()){
            return false;
        }
        data[end++]=d;
        end=end%data.length;
        size++;
        return true;
    }
    public int dequeue() throws Exception{
        if(isEmpty()){
            throw new Exception("Queue is Empty");
        }
        int element=data[front++];
        front=front%data.length;
        size--;
        return element;
    }
    public int peek() throws Exception{
        if(isEmpty()){
            throw new Exception("Queue is Empty");
        }
        return data[front];
    }
}

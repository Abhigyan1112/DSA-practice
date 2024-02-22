package CustomStack;

public class Stack {
    int maxsize;
    int top=-1;
    int size=0;
    public Stack(){
        maxsize=10;
        stack=new int[maxsize];
    }
    public Stack(int maxsize){
        this.maxsize=maxsize;
        stack=new int[maxsize];
    }
    int[] stack;
    public void push(int n){
        if(isFull()){
            System.out.println("Stack is Full");
            return;
        }
        stack[++top]=n;
        size++;
    }
    public int pop(){
        if(isEmpty()){
            System.out.println("Stack is empty");
            return 0;
        }
        size--;
        return stack[top--];
    }
    public boolean isEmpty(){
        return top==-1;
    }
    public boolean isFull(){
        return top==stack.length-1;
    }
}

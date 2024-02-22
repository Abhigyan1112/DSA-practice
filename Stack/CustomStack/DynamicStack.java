package CustomStack;

public class DynamicStack extends Stack{
    public DynamicStack(int maxsize){
        super(maxsize);
    }
    public void push(int n){
        if(isFull()){
            int[] temp=new int[2*stack.length];
            for(int i=0;i<stack.length;i++){
                temp[i]=stack[i];
            }
            stack=temp;
        }
        super.push(n);
    }
}

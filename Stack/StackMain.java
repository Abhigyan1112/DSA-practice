import CustomStack.*;

import java.util.Scanner;
public class StackMain {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of the stack");
        DynamicStack stack=new DynamicStack(sc.nextInt());
        do{
            System.out.println("Do you want to push or pop");
            String answer=sc.next();
            if(answer.equals("push")){
                System.out.println("Enter the value to be pushed");
                int a=sc.nextInt();
                while(a!=0){
                    stack.push(a);
                    a=sc.nextInt();
                }
            }
            else{
                System.out.println(stack.pop());
            }
        }while(!stack.isEmpty());
        System.out.println("The stack is now empty");
        sc.close();
    }
}

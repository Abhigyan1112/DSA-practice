import java.util.Scanner;
import java.util.Stack;

public class InfPos {
    Stack<Character> stack;     //to store the operands
    char a;     //temporary variable to store character of the statement
    String statement;   //infix notation function 
    InfPos(){   //constructor[]
        stack=new Stack<>();
        a=' ';
    }
    public void input(){    //method to input the infix notation
        Scanner sc=new Scanner(System.in);
        statement=sc.next();
        sc.close();
    }
    public int compat(char op){
        if(op=='^'){
            return 3;
        }
        else if(op=='/' || op=='*'){
            return 2;
        }
        else if(op=='+' || op=='-'){
            return 1;
        }
            return -1;
    }
    public void output(){
        int length=statement.length();
        for(int i=0;i<length;i++){
            a=statement.charAt(i);
            if(a>=65 && a<=90 || a>=97 && a<=122){
                System.out.print(a);
                continue;
            }
            if(a=='('){
                stack.push('(');
            }
            else if(a==')'){
                while(stack.peek()!='('){
                    System.out.print(stack.pop());
                }
                stack.pop();
            }
            else if(stack.isEmpty() || stack.peek()=='(' || compat(a)>compat(stack.peek())){
                stack.push(a);
            }
            else{
                while(!stack.isEmpty() && compat(stack.peek())>=compat(a)){
                    System.out.print(stack.pop());
                }
                stack.push(a);
            }
        }
        while(!stack.isEmpty()){
            System.out.print(stack.pop());
        }
    }
    public static void main(String args[]){
        InfPos infpos=new InfPos();     //creating an object
        infpos.input();
        infpos.output();
    }
}

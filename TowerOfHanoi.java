import java.util.*;
public class TowerOfHanoi{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        tower(N,'A','C','B');
        sc.close();
    }
    public static void tower(int n,char from,char to,char other){
        if(n==1){
            System.out.println("Move disk 1 from "+from+" to "+to);
            return;
        }
        tower(n-1,from,other,to);
        System.out.println("Move disk "+n+" from "+from+" to "+to);
        tower(n-1,other,to,from);
    }
}
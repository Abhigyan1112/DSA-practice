import java.util.*;
public class quickSort {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of the array");
        int N=sc.nextInt();
        int[] A=new int[N];
        System.out.println("Enter the array");
        for(int i=0;i<N;i++){
            A[i]=sc.nextInt();
        }
        Sort(A,0,N-1);
        System.out.println(Arrays.toString(A));
        sc.close();
    }
    static void Sort(int[] A,int low, int high){
        if(low>=high){
            return;
        }
        int start=low;
        int end=high;
        int pivot= A[start + (end-start)/2];
        while(start<=end){
            while(A[start]<pivot){
                start++;
            }
            while(A[end]>pivot){
                end--;
            }
            if(start <= end){
                int temp=A[start];
                A[start]=A[end];
                A[end]=temp;
                start++;
                end--;
            }
        }
        Sort(A,low,end);
        Sort(A,start,high);
    }
}

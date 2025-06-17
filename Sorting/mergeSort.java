import java.util.*;
class mergeSort{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();     // size of the array
        int[] A=new int[N];     // defining the array
        for(int i=0;i<N;i++){   //taking array as input from the user
            A[i]=sc.nextInt();
        }
        System.out.println(Arrays.toString(Sort(A)));   //printing the return statement of Sort function in String form
        sc.close();
    }
    static int[] Sort(int[] A){     //merge sort function which sorts the first half of the array then the second half of the array and then combines them
        if(A.length==1){    // base condition returns array if it has only one element
            return A;
        }
        int mid=A.length/2;
        int[] leftSorted=Sort(Arrays.copyOfRange(A,0,mid));     //copyOfRange returns sub array from first index to second index specified
        int[] rightSorted=Sort(Arrays.copyOfRange(A,mid,A.length));  //again calls the Sort function with the rest half of the array
        return merge(leftSorted,rightSorted);
    }
    static int[] merge(int[] A,int[] B){    //function to merge two arrays
        int[] arr=new int[A.length+B.length];
        int i=0;    //pointer of first array
        int j=0;    //pointer of second array
        int k=0;    //pointer of resultant array
        while(i<A.length && j<B.length){    //adds whichever element is smaller to the resultant array
            if(A[i]<B[j]){
                arr[k]=A[i];
                i++;
            }
            else{
                arr[k]=B[j];
                j++;
            }
            k++;
        }
        while(j<B.length){  //adds the rest part of the array
            arr[k]=B[j];
            j++; k++;
        }
        while(i<A.length){  //adds the rest part of the array
            arr[k]=A[i];
            i++; k++;
        }
        return arr;
    }
}
import java.util.*;
public class BinarySearch{
    public static void main(String args[]){
        int[] array={4,5,3,34,1,5,2,5,4,12};
        Arrays.sort(array);
        System.out.println(binarySearch(array,0,array.length,12));
    }
    private static int binarySearch(int[] array,int start,int end,int target){
        if(start>end) return -1;
        int mid=start+(end-start)/2;
        if(array[mid]==target) return mid;
        else if(array[mid]<target) return binarySearch(array,mid+1,end,target);
        else return binarySearch(array,start,mid-1,target);
    }
}
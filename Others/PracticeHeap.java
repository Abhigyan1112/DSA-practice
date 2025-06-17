import java.util.*;
public class PracticeHeap<T extends Comparable<T>>{
    List<T> list;
    public PracticeHeap(){
        list=new LinkedList<>();
    }

    public void swap(int first,int second){
        T temp=list.get(first);
        list.set(first,list.get(second));
        list.set(second,temp);
    }

    public int parent(int index){
        return (index-1)/2;
    }
    public int left(int index){
        return index*2+1;
    }
    public int right(int index){
        return index*2+2;
    }

    public void insert(T value){
        list.add(value);
        uphead(list.size()-1);
    }

    public void uphead(int index){
        if(index==0) return;
        int p=parent(index);
        while(list.get(p).compareTo(list.get(index))>0){
            swap(p,index);
        }
        uphead(p);
    }

    public void downhead(int index){
        int left=left(index);
        int min=index;
        int right=right(index);
        if(list.get(left).compareTo(list.get(min))<0){
            min=left;
        }
        if(list.get(right).compareTo(list.get(min))<0){
            min=right;
        }
        if(index!=min){
            swap(index,min);
        }
    }

    public T getMin() throws Exception{
        if(list.isEmpty()){
            throw new Exception("heap is empty");
        } 
        T min=list.get(0);

        T last=list.remove(list.size()-1);
        if(!list.isEmpty()){
            list.set(0,last);
            downhead(0);
        }
        return min;
    }
}

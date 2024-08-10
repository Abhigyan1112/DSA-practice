
import java.util.ArrayList;

class Heap<T extends Comparable<T>>{
    private ArrayList<T> list;

    public Heap() {
        list = new ArrayList<>();
    }

    private void Swap(int first, int second) { // to swap two nodes of the heap
        T temp = list.get(first);
        list.set(first, list.get(second));
        list.set(second, temp);
    }

    private int parent(int index) { // to return the index of the parent of a node of the heap
        return (index - 1) / 2;
    }

    private int left(int index) {
        return 2 * index + 1;
    }

    private int right(int index) {
        return 2 * index + 2;
    }

    public void insert(T value) {
        list.add(value);
        uphead(list.size() - 1);
    }

    private void uphead(int index) {
        if (index == 0) {
            return;
        }
        int p = parent(index);
        if (list.get(index).compareTo(list.get(p)) < 0) {
            Swap(p, index);
            uphead(p);
        }
    }

    public T getMin() throws Exception {
        if (list.isEmpty()) {
            throw new Exception("Removing from an empty heap!");
        }
        T temp = list.get(0);

        T last = list.remove(list.size() - 1);
        if (!list.isEmpty()) {
            list.set(0, last);
            downHeap(0);
        }
        return temp;
    }

    private void downHeap(int index) {
        int right = right(index);
        int min = index;
        int left = left(index);
        if (left < list.size() && list.get(min).compareTo(list.get(left)) > 0) {
            min = left;
        }
        if (right < list.size() && list.get(min).compareTo(list.get(right)) > 0) {
            min = right;
        }
        if (index != min) {
            Swap(min, index);
            downHeap(min);
        }
    }

    public ArrayList<T> heapSort() throws Exception {
        ArrayList<T> ans = new ArrayList<>();
        while (!list.isEmpty()) {
            ans.add(getMin());
        }
        return ans;
    }
}
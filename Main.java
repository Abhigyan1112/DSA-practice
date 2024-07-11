
public class Main {
    public static void main(String[] args) throws Exception {
        Heap<Integer> heap = new Heap<>();

        heap.insert(34);
        heap.insert(22);
        heap.insert(11);
        heap.insert(4);
        heap.insert(66);
        heap.insert(55);
        heap.insert(23);
        heap.insert(64);
        System.out.println(heap.heapSort());
    }
}

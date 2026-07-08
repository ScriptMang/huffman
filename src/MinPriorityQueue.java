import java.util.ArrayList;

public class MinPriorityQueue extends MinHeap {
    MinPriorityQueue() {
        super();
    }

    MinPriorityQueue(ArrayList<Node> a) {
        super(a);
    }

    void decrementKey(int idx, int val) {
        if (val >= get(idx).val) {
            System.err.println("val: " + val + " is bigger/equal than the key located at index: " + idx + " idxVal: " + get(idx).val);
            return;
        }
        setFreq(idx, val);
        while (idx > 0 && get(parentIndexOf(idx)).val > val) {
            swap(idx, parentIndexOf(idx));
            idx = parentIndexOf(idx);
        }
    }

    void insert(Node n) {
        heapSize += 1;
        Node sentinel = new Node(n.ch, Integer.MAX_VALUE);
        sentinel.left = n.left;
        sentinel.right = n.right;
        //System.out.println("Current HeapSize: " + heapSize);
        set(heapSize - 1, sentinel);
        decrementKey(heapSize - 1, n.val);
    }

   Node extractMin(){
        if (heapSize < 1)
            System.err.println("heap underflow");
        Node min = min();
        set(0, get(heapSize - 1));
        heapSize--;
        min_Heapify(0);
        return min;
    }

    void printValues() {
        System.out.println("heapsize: " + heapSize);
        for ( int i = 0; i <= ((heapSize - 2)/2); i++) {
            System.out.print("Node char: " + get(i).ch + " val: " + get(i).val);

            int left = leftIndexOf(i);
            if (left < heapSize)
                System.out.print(" LeftChild char: " + get(left).ch + " val: " + get(left).val);
            int right = rightIndexOf(i);
            if (right < heapSize)
                System.out.print(" RightChild char: " + get(right).ch + " val: " + get(right).val);
            System.out.println();
        }
    }
}

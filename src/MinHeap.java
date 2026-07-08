
//Remember to look at programming guidelines when finished again this week
import java.util.ArrayList;

public class MinHeap{
    int heapSize;

    private ArrayList<Node> nodes;

    MinHeap() {
        nodes = new ArrayList<>();
    }

    MinHeap(ArrayList<Node> a) {
        nodes = a;
        buildMinHeap();
    }

    void buildMinHeap() {
        heapSize = nodes.size();
        for (int i = (int)(Math.floor((nodes.size())/ 2)-1); i > -1; i--)
            min_Heapify(i);
    }

    void min_Heapify(int i) {
        int l = leftIndexOf(i);
        int r = rightIndexOf(i);
        int smallest;
        if  ( l < heapSize &&  nodes.get(l).val < nodes.get(i).val)
            smallest = l;
        else
            smallest = i;
        if (r < heapSize && nodes.get(r).val < nodes.get(smallest).val)
            smallest = r;
        if (smallest !=  i) {
            swap(i, smallest);
            min_Heapify(smallest);
        }
    }

    Node min() {
        return nodes.get(0);
    }

    void setElements(ArrayList<Node> elements) {
        nodes = elements;
        buildMinHeap();
    }

    void set(int indx, Node e){
        nodes.set(indx, e);
    }

    void setFreq(int idx, int val){
        nodes.get(idx).val = val;
    }

    void add(Node element) {
        nodes.add(element);
        heapSize += 1;
    }

    Node get(int indx){
       return nodes.get(indx);
    }

    void swap(int i, int j){
        Node temp = get(i);
        set(i, get(j));
        set(j, temp);
    }

    int parentIndexOf(int i) {
        if (i == 0)
            System.err.println("Index cannot be zero");
        return (int)(Math.floor((double)((i-1)/2)));
    }

    int leftIndexOf(int i) {
        return (2*i)+1;
    }

    int rightIndexOf(int i) {
        return (2*i)+2;
    }
}


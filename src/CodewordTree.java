import java.util.ArrayList;

public class CodewordTree {
    private MinPriorityQueue queue;

    int bodySize;
    String [] codewordTable = new String [256];
    Node root;

    CodewordTree(ArrayList<Node> c) {
        queue  = new MinPriorityQueue(c);
        buildTree(c);
    }

    // Returns the integer representation of the binary codeword for a character in the CodewordTree
    // Never ask to find the \0 character which signifies a non character node
    int codeword_for(char target_ch, Node start, int codeword) {
//      System.out.println("StartCh: " + start.ch + " targetCh: " + target_ch);
        if(start.ch == target_ch)
            return codeword;

        if (start.left != null) {
            //System.out.println("in here 1");
            int res = codeword_for(target_ch, start.left, codeword*2);
            if (res != -1) { return res; }
        }
        if (start.right != null) {
            //System.out.println("in here 2");
            int res = codeword_for(target_ch, start.right, (codeword*2)+1);
            if (res != -1) { return res; }
        }
        return -1;
    }

    Node find(char target_ch, Node start) {
        if(start.ch == target_ch)
            return start;
        if (start.left != null)
            find(target_ch, start.left);
        if (start.right != null)
            find(target_ch, start.right);
        return null;
    }

    private void buildTree(ArrayList<Node> a) {
        int n = queue.heapSize;
        for (int i = 0; i < n-1; i++) {
          Node z = new Node('\0', Integer.MAX_VALUE);
          z.left  = queue.extractMin();
          z.right = queue.extractMin();
          z.val  = z.left.val + z.right.val;
         // System.out.println("z: " + z.val + " i: " + i + " z-left: " + z.left.ch + " z-right: " + z.right.ch);
          queue.insert(z);
        }
        root = queue.extractMin();
        bodySize = bodySize(root, 0, 0);
    }

    int bodySize(Node start, int bitTotal, int level) {
        if (start.ch != '\0') { return (level * start.val); }

        int leftRes = 0;
        if (start.left != null) {
            leftRes = bodySize(start.left, 0, level+1);
        }

        int rightRes = 0;
        if (start.right != null) {
            rightRes = bodySize(start.right, 0, level + 1);
        }
        return leftRes + rightRes;
    }

    char populateCodewordTable(Node start,  char codeword) {
        if (start.ch != '\0' )
            return codeword;

        String lftRes = "";
        if (start.left != null) {
            lftRes += '0';
            lftRes += populateCodewordTable(start.left, '0');
        }

        String rghtRes= "";
        if (start.right != null) {
            rghtRes += '1';
            rghtRes += populateCodewordTable(start.right, '1');
        }

        if (start.ch != '\0') {
            int x = start.ch;
            System.out.println(start.ch + ": " + x);
            codewordTable[start.ch]= lftRes;
        }

        if (start.right.ch != '\0'){
            int y = start.right.ch;
            System.out.println(start.right.ch + ": " + y);
            codewordTable[start.right.ch]= rghtRes;
        }

        return codeword;
    }

    void printTree(Node start) {
        System.out.println("Current Node: " + start.ch + " frequency: " + start.val);
        if (start.left != null) {
            System.out.println("\t\tLeft Node: " + start.left.ch + " frequency: " + start.left.val);
            printTree(start.left);
        }

        if (start.right != null) {
            System.out.println("\t\tRight Node: " + start.right.ch + " frequency: " + start.right.val);
            printTree(start.right);
        }
    }
}

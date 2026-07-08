import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        int indx = 0;
        ArrayList<Node> b = new ArrayList<Node>(Arrays.asList( new Node('a', 34), new Node('b', 23),
                new Node('f', 56), new Node('e', 11) , new Node('h', 20),  new Node('o', 21),
        new Node('n', 26), new Node('l', 19), new Node('z', 12), new Node('j', 45)));

        CodewordTree wordTree = new CodewordTree(b);
        wordTree.populateCodewordTable(wordTree.root,'0');
        for (int i = 0; i < 256; i++)
            System.out.println("Current Index: " + i + " CodeWord: " + wordTree.codewordTable[i]);

       // wordTree.printTree(wordTree.root);

        // File requires pathname of file in question you want to be read
//        ArrayList<Node> freqList = new ArrayList<>();
//       try {
//            File file = new File(args[0]) ;
//            BufferedReader buff = new BufferedReader(new FileReader(file));
//            String lst= "";
//            int st2;
//            while ((st2= buff.read()) != -1) {
//                char c = (char) st2;
//                // System.out.print(c);
//                if (!(lst.contains(Character.toString(c)))) {
//                    Node d = new Node(c, 1);
//                    freqList.add(indx++, d);
//                    lst += c;
//                }
//                else {
//                    int i = lst.indexOf(c);
//                    freqList.get(i).val += 1;
//                    System.out.println("The letter " + c + " has been repeated " + freqList.get(i).val + "times" );
//                }
//            }
//            CodewordTree  wordTree = new CodewordTree(freqList);
//            System.out.println("The TotalBitSize: " + wordTree.bodySize(wordTree.root, 0, 0));
//        } catch(IndexOutOfBoundsException e){
//            System.err.println(" Caught IndexOutofBounds Exception: no file was specified to be read or index > size of the array");
//        } catch(FileNotFoundException e) {
//            System.err.println(" Caught FileException: The file was not found or does not exist" );
//        }
    }
}

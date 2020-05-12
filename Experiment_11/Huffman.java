import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

//node class is the basic structure
class HuffmanNode{
    int weight;
    char c;
    HuffmanNode left;
    HuffmanNode right;
}

class MyComparator implements Comparator<HuffmanNode>{
    public int compare(HuffmanNode x, HuffmanNode y){
        return x.weight - y.weight;
    }
}

public class Huffman {
    //print huffmanNode
    public static void printCode(HuffmanNode root, String s){
        if(root.left==null && root.right==null && Character.isLetter(root.c)){
            System.out.println(root.c + ":" + s);
            return;
        }
        printCode(root.left, s+"0");
        printCode(root.right, s+"1");
    }
    public  static void main(String[] args){
        int n = 6;
        char[] charArray = {'a', 'b', 'c', 'd', 'e', 'f'};
        int[] charFreq = {5, 9, 12, 13, 16, 45};

        //create a min-priority queue q
        PriorityQueue<HuffmanNode> q =
                new PriorityQueue<HuffmanNode>(n, new MyComparator());

        for(int i = 0; i < n; i++){
            HuffmanNode hn = new HuffmanNode();
            hn.c = charArray[i];
            hn.weight = charFreq[i];
            hn.left = null;
            hn.right = null;
            q.add(hn);
        }
        HuffmanNode root = null;
        while(q.size() > 1){
            HuffmanNode x = q.peek();
            q.poll();
            HuffmanNode y = q.peek();
            q.poll();
            HuffmanNode temp = new HuffmanNode();
            temp.c = '-';
            temp.weight = x.weight+y.weight;
            temp.left = x;
            temp.right = y;
            root = temp;
            q.add(temp);
        }
        printCode(root, "");
    }
}

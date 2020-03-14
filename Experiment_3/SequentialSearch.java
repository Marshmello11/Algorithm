import java.util.*;
import java.io.*;

public class SequentialSearch {

    int SeqSearch(int list[], int target){
        for(int i = 1; i < list.length; i++){
            if(list[i] == target) return i;
        }
        return 0;
    }

    public static void main(String[] args){
        int list[] = {-1, 2, 3, 4, 7, 9, 12, 23, 27, 34, 45};
        SequentialSearch result = new SequentialSearch();
        System.out.println(result.SeqSearch(list, 55));
    }
}

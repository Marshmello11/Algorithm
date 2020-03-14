import java.io.*;
import java.util.*;

public class BinarySearch {

    int BiSearch(int list[], int target){
        int left = 1;
        int right = list.length;
        int middle = (left+right)/2;
        while(left <= right){
            if(list[middle] == target) return middle;
            else if(list[middle] > target) right = middle - 1;
            else if(list[middle] < target) left = middle + 1;
        }
        return 0;
    }

    public static void main(String[] args){
        int list[] = {-1, 2, 3, 4, 7, 9, 12, 23, 27, 34, 45};
        BinarySearch result = new BinarySearch();
        System.out.println(result.BiSearch(list, 12));
    }
}


public class MergeSort {
    public void merge(int[] list, int left, int mid, int right){
        int[] tmp = new int[list.length];
        int p1 = left, p2 = mid + 1, k = left;
        while(p1 <= mid && p2 <= right){
            if(list[p1] <= list[p2])
                tmp[k++] = list[p1++];
            else
                tmp[k++] = list[p2++];
        }

        while(p1 <= mid) tmp[k++] = list[p1++];
        while(p2 <= right) tmp[k++] = list[p2++];

        for(int i = left; i <= right; i++)
            list[i] = tmp[i];
    }

    public void mergeSort(int[] list, int start, int end){
        if(start < end){
            int mid = (start + end)/2;
            mergeSort(list, start, mid);
            mergeSort(list, mid+1, end);
            merge(list, start, mid, end);
        }
    }

    public static void main(String[] args){
        int[] list = {49, 38, 65, 97, 76, 13, 27, 50};
        MergeSort ms = new MergeSort();
        ms.mergeSort(list, 0, list.length-1);
        for(int element : list){
            System.out.print(element + " ");
        }
    }
}

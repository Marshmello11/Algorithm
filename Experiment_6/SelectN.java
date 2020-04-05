
public class SelectN {

    public static void swap(int a[], int i,int j){
        int temp=a[j];
        a[j] = a[i];
        a[i] = temp;
    }
    //冒泡排序
    public static void bubbleSort(int a[], int l, int r){
        for(int i=l; i<r; i++)
        {
            for(int j=i+1; j<=r; j++)
            {
                if(a[j]<a[i])swap(a,i,j);
            }
        }
    }
    //递归寻找中位数的中位数
    public static int FindMid(int a[], int l, int r){
        if(l == r) return l;
        int i = 0;
        int n = 0;
        for(i = l; i < r - 5; i += 5)
        {
            bubbleSort(a, i, i + 4);
            n = i - l;
            swap(a,l+n/5, i+2);
        }
        //处理剩余元素
        int num = r - i + 1;
        if(num > 0)
        {
            bubbleSort(a, i, i + num - 1);
            n = i - l;
            swap(a,l+n/5, i+num/2);
        }
        n /= 5;
        if(n == l) return l;
        return FindMid(a, l, l + n);
    }
    //进行划分过程
    public static int Partion(int a[], int l, int r, int p){
        swap(a,p, l);
        int i = l;
        int j = r;
        int pivot = a[l];
        while(i < j)
        {
            while(a[j] >= pivot && i < j)
                j--;
            a[i] = a[j];
            while(a[i] <= pivot && i < j)
                i++;
            a[j] = a[i];
        }
        a[i] = pivot;
        return i;
    }

    public static int Select(int a[], int l, int r, int k){
        int p = FindMid(a, l, r);    //寻找中位数的中位数
        int i = Partion(a, l, r, p);

        int m = i - l + 1;
        if(m == k) return a[i];
        if(m > k)  return Select(a, l, i - 1, k);
        return Select(a, i + 1, r, k - m);
    }
    public static void main(String[] args) {
        int a[]= {3,0,7,6,5,9,8,2,1,4,13,11,17,16,15,19,18,12,10,14,23,21,
                27,26,25,29,28,22,20,24,33,31,37,36,35,39,38,32,30,34,43,41,47,46,45,49,
                48,42,40,44,53,51,57,56,55,59,58,52,50,54,63,61,67,66,65,69,68,62,60,64,
                73,71,77,76,75,79,78,72,70,74};
        for(int i = 0; i < 80; i++){
            System.out.println("第"+(i+1)+"小数为： "+Select(a, 0, 79, i+1));
        }
    }
}



package Merge_Sort;

import java.lang.reflect.Array;

public class MergeAlgo {
    static void merge(int arr[], int beg, int mid, int end) {
        int i, j, k;
        int n1 = mid - beg + 1;
        int n2 = end - mid;
        int leftarr[] = new int[n1];
        int rightarr[] = new int[n2];
        for (i = 0; i < n1; i++) {
            leftarr[i] = arr[beg + i];
        }
        for (j = 0; j < n1; j++) {
            rightarr[j] = arr[mid + 1 + j];
        }
        i = 0;
        j = 0;
        k = beg;
        while (i < n1 && j < n2) {
            if (leftarr[i] <= rightarr[j]) {
                arr[k] = leftarr[i];
                i++;
            }
            else{
                arr[k] = rightarr[j];
                j++;
            }
            k++;
        }
        while(i<n1){
            arr[k] =leftarr[i];
            i++;
            k++;
        }
        while(j<n2){
            arr[k] =rightarr[j];
            j++;
            k++;
        }
    }
    static void sort(int arr[],int beg , int end){
        if(beg < end){
            int mid = (beg+end)/2;
            sort(arr,beg,mid);
            sort(arr,mid+1,end);
            merge(arr,beg,mid,end);
        }


    }
    static void printArray(int a[], int n)
    {
        int i;
        for (i = 0; i < n; i++)
            System.out.print(a[i] + " ");
    }
    public static void main(String args[])
    {
        int a[] = { 11, 30, 24, 7, 31, 16, 39, 41 };
        int n = a.length;
        System.out.println("before");

        printArray(a,n);
        sort(a,0,n-1);
        System.out.println("\nafter\n");

        printArray(a,n);

    }
}

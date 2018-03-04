package solution;

import org.junit.Test;

/**
 * The set [1,2,3,…,n] contains a total of n! unique permutations.
 *
 * By listing and labeling all of the permutations in order,
 * We get the following sequence (ie, for n = 3):
 *
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * Given n and k, return the kth permutation sequence.
 *
 * Note: Given n will be between 1 and 9 inclusive.
 *
 *
 */

//求出一个数组的第K个排列
public class N060_PermutationSequence {
    public String getPermutation(int n, int k) {
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }

        for (int i = 0; i < k - 1; i++) {
            getPermutation(arr);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
        }
        return sb.toString();
    }

    public void getPermutation(int[] arr){
        int pos = arr.length - 2;
        while (pos >= 0 && arr[pos] >= arr[pos+1]){
            pos--;
        }
        if(pos == -1) return;

        for (int i = arr.length-1; i > pos; i--) {
            if(arr[i] > arr[pos]) {
                swap(arr, i, pos);
                reserve(arr, pos+1, arr.length - 1);
                return;
            }
        }
    }

    public void reserve(int[] arr,int start,int end){
        while (start < end){
            swap(arr,start++,end--);
        }
    }

    public void swap(int[] arr,int i,int j){
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    @Test
    public void test(){
        System.out.println(getPermutation(3,1));
        System.out.println(getPermutation(3,2));
        System.out.println(getPermutation(3,3));
        System.out.println(getPermutation(3,4));
        System.out.println(getPermutation(3,5));
        System.out.println(getPermutation(3,6));
    }
}

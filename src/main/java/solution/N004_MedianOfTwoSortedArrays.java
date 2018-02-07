package solution;
//There are two sorted arrays nums1 and nums2 of size m and n respectively.
//Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
//
//        Example 1:
//        nums1 = [1, 3]
//        nums2 = [2]
//
//        The median is 2.0
//        Example 2:
//        nums1 = [1, 2]
//        nums2 = [3, 4]
//
//        The median is (2 + 3)/2 = 2.5

/**
 * 题目大意：
 * 求两个排序数组的中位数
 * 时间复杂度应该为O(log (m+n))
 */
public class N004_MedianOfTwoSortedArrays {

    //博客解析：http://blog.csdn.net/hk2291976/article/details/51107778
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        //保证数组长度短的在前面
        if(n > m) return findMedianSortedArrays(nums2,nums1);
        int L1 = 0,L2 = 0,R1 = 0,R2 = 0,C1 = 0,C2 = 0;
        int LO = 0,HI = n * 2;;
        while (LO <= HI){
            C1 = (LO + HI)/2;
            C2 = (m + n) - C1;

            L1 = C1 == 0 ? Integer.MIN_VALUE : nums1[(C1-1)/2];
            R1 = C1 == n * 2 ? Integer.MAX_VALUE : nums1[C1/2];
            L2 = C2 == 0 ? Integer.MIN_VALUE : nums2[(C2-1)/2];
            R2 = C2 == m * 2 ? Integer.MAX_VALUE : nums2[C2/2];

            if(L1 > R2) HI = C1 - 1;
            else if(L2 > R1) LO = C1 + 1;
            else break;
        }

        return (Math.max(L1,L2) + Math.min(R1,R2))/2.0;
    }
}

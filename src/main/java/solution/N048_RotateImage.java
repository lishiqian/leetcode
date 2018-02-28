package solution;

import org.junit.Test;

import java.util.ArrayList;

/**
 * You are given an n x n 2D matrix representing an image.
 *
 * Rotate the image by 90 degrees (clockwise).
 *
 * Note:
 * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.
 *
 * Example 1:
 *
 * Given input matrix =
 * [
 * [1,2,3],
 * [4,5,6],
 * [7,8,9]
 * ],
 *
 * rotate the input matrix in-place such that it becomes:
 * [
 * [7,4,1],
 * [8,5,2],
 * [9,6,3]
 * ]
 * Example 2:
 *
 * Given input matrix =
 * [
 * [ 5, 1, 9,11],
 * [ 2, 4, 8,10],
 * [13, 3, 6, 7],
 * [15,14,12,16]
 * ],
 *
 * rotate the input matrix in-place such that it becomes:
 * [
 * [15,13, 2, 5],
 * [14, 3, 4, 1],
 * [12, 6, 8, 9],
 * [16, 7,10,11]
 * ]
 */
public class N048_RotateImage {

    //方法一 每个值和对应的角度顺 四个数循环交换
//    public void rotate(int[][] matrix) {
//        int start = 0;
//        int end = matrix.length-1;
//        while (start < end){
//            rotate(matrix,start,end);
//            start++;
//            end--;
//        }
//
//        System.out.println(0);
//    }
//
//    public void rotate(int[][] matrix,int start,int end) {
//        int t = 0;
//        for (int i = start; i < end; i++) {
//            t = matrix[start][i];
//            matrix[start][i] = matrix[end-(i - start)][start];
//            matrix[end-(i - start)][start] = matrix[end][end-(i - start)];
//            matrix[end][end-(i - start)] = matrix[i][end];
//            matrix[i][end] = t;
//        }
//    }

    //方法二 沿着对角线翻转 左右对称
//    he idea was firstly transpose the matrix and then flip it symmetrically. For instance,
//
//        1  2  3
//        4  5  6
//        7  8  9
//    after transpose, it will be swap(matrix[i][j], matrix[j][i])
//
//        1  4  7
//        2  5  8
//        3  6  9
//    Then flip the matrix horizontally. (swap(matrix[i][j], matrix[i][matrix.length-1-j])
//
//        7  4  1
//        8  5  2
//        9  6  3
//    Hope this helps.

    public void rotate(int[][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix.length; j++){
                int t = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = t;
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length/2; j++) {
                int t = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length - 1 - j];
                matrix[i][matrix.length - 1 - j] = t;
            }
        }
    }



    @Test
    public void test(){
        int[][] matrix = new int[4][];
        matrix[0] = new int[]{1,2,3,4};
        matrix[1] = new int[]{5,6,7,8};
        matrix[2] = new int[]{9,10,11,12};
        matrix[3] = new int[]{13,14,15,16};

        rotate(matrix);


        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(5);
        list.add(4);
        list.add(2);
        list.add(3);
        list.add(5);
        list.add(2);
        list.add(3);
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);

//        for (int i = 0; i < list.size(); i++) {
//            for (int j = i + 1; j < list.size(); j++) {
//                if(list.get(i) == list.get(j)){
//                    list.remove(j);
//                }
//            }
//        }

        for (int  i = list.size()-1; i >= 0; i--) {
            for (int j = i - 1 ; j >= 0; j--) {
                if(list.get(i) == list.get(j)){
                    list.remove(j);
                    i--;
                }
            }
        }

        System.out.println(list);
    }
}

package solution;

/**
 * Given a non-negative integer represented as a non-empty array of digits, plus one to the integer.
 *
 * You may assume the integer do not contain any leading zero, except the number 0 itself.
 *
 * The digits are stored such that the most significant digit is at the head of the list.
 */

/**
 * 题目大意：
 * 给你一个非负整数数组代表一个整数，高位数在前面，返回这个整数加1的值
 */
public class N066_PlusOne {
//    public int[] plusOne(int[] digits) {
//        boolean flag = false;
//        for (int i = digits.length - 1; i >= 0; i--) {
//            if(digits[i] == 9){
//                if(i == 0){
//                    flag = true;
//                }
//                digits[i] = 0;
//
//            }else{
//                digits[i]++;
//                return digits;
//            }
//        }
//
//        if(flag){
//            int[] resDigits = new int[digits.length + 1];
//            resDigits[0] = 1;
//            System.arraycopy(digits,0,resDigits,1,digits.length);
//            return resDigits;
//        }
//        else return digits;
//    }

    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if(digits[i] == 9){
                digits[i] = 0;
            }else {
                digits[i] ++;
                return digits;
            }
        }
        //由于进位是从最低为开始的所以除了最高为 其他应该为都为0 如99999 -> 100000
        int[] resDigit = new int[digits.length+1];
        resDigit[0] = 1;
        return resDigit;
    }
}

package solution;

/**
 * Given two binary strings, return their sum (also a binary string).
 *
 * For example,
 * a = "11"
 * b = "1"
 * Return "100".
 */
public class N067_AddBinary {
    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();

        int aLen = a.length() - 1;
        int bLen = b.length() - 1;

        int caary = 0;
        while (aLen >= 0 || bLen >= 0){
            int numA = 0,numB = 0;
            if(aLen >= 0) numA = a.charAt(aLen--) - '0';
            if(bLen >= 0) numB = b.charAt(bLen--) - '0';

            int sum = numA + numB + caary;

            if(sum <= 1){
                caary = 0;
                result.append(sum);
            }else {
                caary = 1;
                result.append(sum % 2);
            }
        }

        if(caary != 0){
            result.append(1);
        }

        result.reverse();
        return result.toString();
    }
}

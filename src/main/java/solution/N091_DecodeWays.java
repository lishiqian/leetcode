package solution;

/**
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 *
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Given an encoded message containing digits, determine the total number of ways to decode it.
 *
 * For example,
 * Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
 *
 * The number of ways decoding "12" is 2.
 */
public class N091_DecodeWays {
    public int numDecodings(String s) {
        if(s == null || s.length() == 0) return 0;
        int r1 = 1,r2 = 1;
        for (int i = 1; i < s.length(); i++) {
            if(s.charAt(i) == '0') r1 = 0;

            if (s.charAt(i - 1) == '1' || s.charAt(i - 1) == '2' && s.charAt(i) <= '6') {
                r1 = r2 + r1;
                r2 = r1 - r2;
            } else{
                r2 = r1;
            }
        }

        return s.charAt(0)== '0' ? 0:r1;
    }


}

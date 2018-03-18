package solution;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.
 *
 * For example:
 * Given "25525511135",
 *
 * return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
 */

/**
 * 题目大意：
 * 给你一串字符串，返回满足ip格式的所有可能的字符串
 */
public class N093_RestoreIPAddresses {
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<String>();
        int len = s.length();
        for (int i = 1; i <= 3; i++) {
            if(len - i > 9) continue;
            for (int j = i + 1; j <= i + 3; j++) {
                if(len - j > 6) continue;
                for (int k = j + 1; k <= j + 3 && k < len; k++) {
                    int a = Integer.valueOf(s.substring(0,i));
                    int b = Integer.valueOf(s.substring(i,j));
                    int c = Integer.valueOf(s.substring(j,k));
                    int d = Integer.valueOf(s.substring(k));
                    if(a > 255 || b > 255 || c > 255 || d > 255) continue;

                    String ip = a + "." + b + "." + c + "." + d;
                    if(ip.length() == len + 3) ans.add(ip);
                }
            }
        }

        return ans;
    }

    public int getInt(String s,int start,int end){
        int num = 0;
        for (int i = start; i <= end; i++) {
            num *= 10;
            num += s.charAt(i) - '0';
        }
        return num;
    }
}

package solution;

/**
 * Given an absolute path for a file (Unix-style), simplify it.
 *
 * For example,
 * path = "/home/", => "/home"
 * path = "/a/./b/../../c/", => "/c"
 * click to show corner cases.
 *
 * Corner Cases:
 * Did you consider the case where path = "/../"?
 * In this case, you should return "/".
 * Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
 * In this case, you should ignore redundant slashes and return "/home/foo".
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 题目大意：
 * 简化路径
 * ..表示取消上一级路径 如： /aaa/bbb/../ccc -> /aaa/ccc
 */
public class N071_SimplifyPath {
    public String simplifyPath(String path) {
        String[] p = path.split("/");
        Stack<String> stack = new Stack<String>();
        for (int i = 0; i < p.length; i++) {
            if(!stack.isEmpty() && p[i].equals(".."))
                stack.pop();
            else if(!p[i].equals(".") && !p[i].equals("") && !p[i].equals(".."))
                stack.push(p[i]);
        }
        List list = new ArrayList(stack);
        return "/" + String.join("/",list);
    }
}

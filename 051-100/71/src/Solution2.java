
import java.util.Stack;

/**
 * For example,
 * path = "/home/", => "/home"
 * path = "/a/./b/../../c/", => "/c"
 * <p>
 * Created by liwei on 17/9/15.
 * <p>
 * Last executed input:
 * "/.."
 */
public class Solution2 {

    public String simplifyPath(String path) {
        String result = "";
        String[] pathList = path.split("/");
        if (pathList.length == 0) {
            return "/";
        }

        Stack<String> stack = new Stack<>();
        for (String p : pathList) {
            if ("".equals(p) || ".".equals(p)) {
                continue;
            }
            if ("..".equals(p)) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else { // 是正常的路径字符串的时候，入栈
                stack.push(p);
            }
        }


        // 现在考虑输出字符串
        while (!stack.isEmpty()) {
            result = "/" + stack.pop() + result;
        }
        if ("".equals(result)) {
            result = "/";
        }
        return result;
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();

        String path1 = "/home/";
        String result1 = solution2.simplifyPath(path1);
        System.out.println(result1);


        String path2 = "/a/./b/../../c/";
        String result2 = solution2.simplifyPath(path2);
        System.out.println(result2);


        String path3 = "/..";
        String result3 = solution2.simplifyPath(path3);
        System.out.println(result3);

        String path4 = "/..";
        String result4 = solution2.simplifyPath(path4);
        System.out.println(result4);

        String path5 = "/abc/def/.";
        String result5 = solution2.simplifyPath(path5);
        System.out.println(result5);
    }
}

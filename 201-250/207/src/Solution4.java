import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 该方法还存储了拓扑排序的结果，个人觉得这种写法很好理解，根据这个写法可以马上写出 LeetCode 第 210 题 课程表 II
 * 参考资料：https://www.cnblogs.com/yrbbest/p/4493547.html
 *
 * @author liwei
 * @date 18/6/24 下午12:20
 */
public class Solution4 {

    /**
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0) {
            return false;
        }
        int plen = prerequisites.length;
        if (plen == 0) {
            return true;
        }
        int[] inDegree = new int[numCourses];
        for (int[] p : prerequisites) {
            inDegree[p[0]]++;
        }
        LinkedList<Integer> queue = new LinkedList<>();
        // 首先加入入度为 0 的结点
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.addLast(i);
            }
        }
        // 拓扑排序的结果
        List<Integer> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            Integer num = queue.removeFirst();
            res.add(num);
            // 把邻边全部遍历一下
            for (int[] p : prerequisites) {
                if (p[1] == num) {
                    inDegree[p[0]]--;
                    if (inDegree[p[0]] == 0) {
                        queue.addLast(p[0]);
                    }
                }
            }
        }
        // System.out.println("拓扑排序结果：");
        // System.out.println(res);
        return res.size() == numCourses;
    }

    public static void main(String[] args) {
        int[][] prerequisites = new int[][]{{1, 0}, {2, 6},
                {1, 7}, {6, 4}, {7, 0}, {0, 5}};
        int numCourses = 8;
        Solution4 solution4 = new Solution4();
        boolean canFinish = solution4.canFinish(numCourses, prerequisites);
        System.out.println(canFinish);
    }
}

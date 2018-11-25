
import java.util.ArrayList;
import java.util.List;

/**这种解法显得更自然一些，遍历了从根节点到叶子节点的每一个节点，然后累加计算加到了多少，这是与老师的思路不同的一种思路。
 * Created by liwei on 17/9/26.
 */
public class Solution3 {

    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        getSum(root, new ArrayList<Integer>(), 0, sum);
        return result;
    }

    private void getSum(TreeNode node, ArrayList<Integer> list, int current, int sum) {
        if (node == null) {
            return;
        }
        current += node.val;
        list.add(node.val);
        if (node.left == null && node.right == null) {
            if (current == sum) {
                result.add(list);
            } else {
                // 什么都不做
                return;
            }
        }
        if (node.left != null) {
            getSum(node.left, new ArrayList<Integer>(), current, sum);
        }
        if (node.right != null) {
            getSum(node.right, new ArrayList<Integer>(), current, sum);
        }
    }
}

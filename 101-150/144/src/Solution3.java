
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

enum UseType {
    RECURSION, ADD
}


/**
 * 我们自定义的 Command 类
 */
class MyCommand {
    UseType useType; // 是对这个节点进行操作，还是递归调用这个节点
    TreeNode treeNode;

    MyCommand(UseType useType, TreeNode treeNode) {
        this.useType = useType;
        this.treeNode = treeNode;
    }
}

public class Solution3 {

    /**
     * 非递归就是要顺序执行，所以不用自己声明一个递归函数来完成
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<MyCommand> stack = new Stack<>();
        stack.push(new MyCommand(UseType.RECURSION, root));
        while (!stack.isEmpty()) {
            MyCommand currentCommand = stack.pop();
            if (UseType.ADD == currentCommand.useType) {
                result.add(currentCommand.treeNode.val);
            } else {
                assert UseType.RECURSION == currentCommand.useType; // 模拟系统栈的作用，注意，应该倒过来写
                if (currentCommand.treeNode.right != null) {
                    stack.push(new MyCommand(UseType.RECURSION, currentCommand.treeNode.right));
                }
                if (currentCommand.treeNode.left != null) {
                    stack.push(new MyCommand(UseType.RECURSION, currentCommand.treeNode.left));
                }
                stack.push(new MyCommand(UseType.ADD, currentCommand.treeNode));
            }
        }
        return result;
    }
}

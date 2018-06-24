import java.util.Arrays;

/**
 * @author liwei
 * @date 18/6/20 上午11:05
 */
public class Solution4 {

    // 有贪心选择的意思
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        // 先考虑极端输入
        if (len <= 1) {
            return len;
        }
        // tail 数组的定义：长度为 i+1 的上升子序列的末尾最小是几
        int[] tail = new int[len];
        // 遍历一遍整个数组，使用二分查找算法
        tail[0] = nums[0];
        int res = 0;
        for (int i = 1; i < len; i++) {
            // 比 tail 数组实际有效的末尾的那个元素还大
            if (nums[i] > tail[res]) {
                // 直接添加在那个元素的后面
                tail[++res] = nums[i];
            } else {
                // 二分查找到第 1 个比 nums[i] 还大的元素，更新到那个位置
                int l = 0;
                int r = res;
                while (l < r) {
                    int mid = l + (r - l) / 2;
                    // 有就啥都不做了
                    if (tail[mid] == nums[i]) {
                        l = mid;
                        break;
                    } else if (tail[mid] >= nums[i]) {
                        r = mid;
                    } else {
                        l = mid + 1;
                    }
                }
                tail[l] = nums[i];
            }
            printArray(nums[i], tail);
        }
        return ++res;
    }

    // 调试方法，以观察是否运行正确
    private void printArray(int num, int[] tail) {
        System.out.print("当前数字：" + num);
        System.out.print("\t当前 tail 数组：");
        int len = tail.length;
        for (int i = 0; i < len; i++) {
            if (tail[i] == 0) {
                break;
            }
            System.out.print(tail[i] + ", ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 5, 6, 2, 5, 4, 19, 5, 6, 7, 12};
        Solution4 solution4 = new Solution4();
        int lengthOfLIS = solution4.lengthOfLIS(nums);
        System.out.println("最长上升子序列的长度：" + lengthOfLIS);
    }
}

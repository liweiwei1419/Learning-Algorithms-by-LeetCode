import java.util.Arrays;

/**
 * @author liwei
 * @date 2019/7/1 6:01 AM
 */
public class Solution4 {

    public int[] searchRange(int[] nums, int target) {
        int len = nums.length;
        // 特判，这一步很重要，否则执行到后序方法可能会出现数组下标越界
        // 同时后序两个方法也不用做特殊判断了
        if (len == 0) {
            return new int[]{-1, -1};
        }

        int num1 = findLowerBound(nums, target);
        // 细节：如果左边界都搜索不到，右边界也没有必要看了
        if (num1 == -1) {
            return new int[]{-1, -1};
        }
        int num2 = findUpBound(nums, target);
        return new int[]{num1, num2};
    }


    private int findLowerBound(int[] nums, int target) {
        // 找大于等于 target 的第 1 个数的索引，小于一定不符合要求
        int len = nums.length;
        int l = 0;
        int r = len - 1;
        while (l < r) {
            // 根据分支逻辑，这里选择左中位数
            int mid = l + (r - l) / 2;
            // 因为找大于等于 target 的第 1 个数，因此小于一定不符合要求
            // 把它写在分支的前面
            if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        // 因为有可能不存在目标元素，最后一定要单独判断一下
        if (nums[l] != target) {
            return -1;
        }
        return l;
    }

    private int findUpBound(int[] nums, int target) {
        // 找小于等于 target 的最后 1 个数的索引，大于一定不符合要求
        // 因为有可能不存在，最后一定要单独判断一下
        int len = nums.length;
        int l = 0;
        int r = len - 1;
        while (l < r) {
            // 根据分支逻辑，这里选择右中位数
            int mid = l + (r - l + 1) / 2;
            // 因为找小于等于 target 的最后 1 个数，因此大于一定不符合要求
            // 把它写在分支的前面
            if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid;
            }
        }
        // 因为有可能不存在目标元素，最后一定要单独判断一下
        if (nums[l] != target) {
            return -1;
        }
        return l;
    }

    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;
        Solution4 solution4 = new Solution4();
        int[] res = solution4.searchRange(nums, target);
        System.out.println(Arrays.toString(res));
    }
}

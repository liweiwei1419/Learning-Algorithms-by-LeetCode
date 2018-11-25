import java.util.PriorityQueue;

/**
 * @author liwei
 * @date 18/7/2 下午7:26
 */
public class Solution3 {

    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        if (len == 0 || k > len) {
            throw new IllegalArgumentException("参数错误");
        }
        // 使用一个含有 k 个元素的最小堆
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(k, (a, b) -> a - b);
        for (int i = 0; i < k; i++) {
            priorityQueue.add(nums[i]);
        }
        for (int i = k; i < len; i++) {
            // 看一眼
            Integer topEle = priorityQueue.peek();
            // 只要当前遍历的元素比堆顶元素大，堆顶出栈，遍历的元素进去
            if (nums[i] > topEle) {
                priorityQueue.poll();
                priorityQueue.add(nums[i]);
            }
        }
        return priorityQueue.peek();
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k = 4;
        Solution3 solution3 = new Solution3();
        int solution2KthLargest = solution3.findKthLargest(nums, k);
        System.out.println(solution2KthLargest);
    }
}

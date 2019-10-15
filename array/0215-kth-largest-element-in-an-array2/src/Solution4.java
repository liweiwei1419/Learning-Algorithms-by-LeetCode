import java.util.PriorityQueue;

/**
 * @author liwei
 * @date 18/7/2 下午7:45
 */
public class Solution4 {

    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        // 最小堆
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(k + 1, (a, b) -> (a - b));
        for (int i = 0; i < k; i++) {
            priorityQueue.add(nums[i]);
        }
        for (int i = k; i < len; i++) {
            priorityQueue.add(nums[i]);
            priorityQueue.poll();
        }
        return priorityQueue.peek();
    }
}

import java.util.PriorityQueue;

/**
 * @author liwei
 * @date 2019/8/10 10:57 AM
 */
public class Solution5 {
    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        // 最小堆
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(k + 1, (a, b) -> (a - b));
        for (int num : nums) {
            priorityQueue.add(num);
            if (priorityQueue.size() == k + 1) {
                priorityQueue.poll();
            }
        }
        return priorityQueue.peek();
    }
}

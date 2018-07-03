import java.util.PriorityQueue;

/**
 * @author liwei
 * @date 18/7/2 下午7:45
 */
public class Solution4 {

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(k + 1, (a, b) -> (a - b));
        for (int num : nums) {
            priorityQueue.add(num);
            if(priorityQueue.size()==k+1){
                priorityQueue.poll();
            }
        }
        return priorityQueue.peek();
    }
}

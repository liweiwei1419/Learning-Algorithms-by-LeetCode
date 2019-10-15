/**
 * @author liweiwei1419
 * @date 2019/10/12 11:38 上午
 */
public class Solution {

    // 非标准的计数排序

    public void sortColors(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return;
        }
        int[] count = new int[3];
        for (int num : nums) {
            count[num]++;
        }
        int next = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < count[i]; j++) {
                nums[next] = i;
                next++;
            }
        }

    }
}

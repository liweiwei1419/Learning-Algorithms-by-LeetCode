/**
 * @author liwei
 * @date 2019/7/12 9:51 AM
 */
public class Solution3 {

    public void sortColors(int[] nums) {
        int[] counter = new int[3];
        for (int num : nums) {
            counter[num] += 1;
        }
        int index = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < counter[i]; j++) {
                nums[index] = i;
                index += 1;
            }
        }
    }
}

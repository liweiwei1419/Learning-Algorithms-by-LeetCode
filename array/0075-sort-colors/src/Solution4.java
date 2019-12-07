/**
 * @author liweiwei1419
 * @date 2019/11/23 11:11 下午
 */
public class Solution4 {

    // 计数排序（不规范的代码示例）

    public void sortColors(int[] nums) {
        int[] cnt = new int[3];
        for (int num:nums) {
            cnt[num]++;
        }
        int k = 0;
        for (int i = 0; i < 3; i++) {
            while (cnt[i]-- > 0) nums[k++] = i;
        }
    }
}

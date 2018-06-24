import java.util.Arrays;
import java.util.Comparator;

class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }
}

/**
 * 动态规划的写法：
 * 先将原问题转换成，最多可以构成多少互不重叠的子区间
 * 然后为最长上升子序列问题使用动态规划求解
 * 最后将子区间的数量 - 上一步所得的结果
 */
public class Solution {
    public int eraseOverlapIntervals(Interval[] intervals) {
        int ilen = intervals.length;
        if (ilen == 0) {
            return 0;
        }

        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if (o1.start != o2.start) {
                    return o1.start - o2.start;
                }
                return o1.end - o2.end;
            }
        });

        // dp[i] 表示以 intervals[i] 为结尾的区间能够成的最长不重叠的区间序列有几个
        int[] dp = new int[ilen];
        Arrays.fill(dp, 1);
        for (int i = 1; i < ilen; i++) {
            for (int j = 0; j < i; j++) {
                if (intervals[i].start >= intervals[j].end) {
                    dp[i] = Integer.max(dp[i], dp[j] + 1);
                }
            }
        }
        // System.out.println(Arrays.toString(dp));
        int res = dp[0];
        for (int i = 1; i < ilen; i++) {
            res = Integer.max(res, dp[i]);
        }
        return ilen - res;
    }

    public static void main(String[] args) {
        Interval interval1 = new Interval(1, 2);
        Interval interval2 = new Interval(1, 2);
        Interval interval3 = new Interval(1, 2);
        Interval[] intervals = new Interval[3];
        intervals[0]=interval1;
        intervals[1]=interval2;
        intervals[2]=interval3;

        Solution solution = new Solution();
        int eraseOverlapIntervals = solution.eraseOverlapIntervals(intervals);
        System.out.println(eraseOverlapIntervals);
    }
}
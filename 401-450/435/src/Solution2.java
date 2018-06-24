import java.util.Arrays;
import java.util.Comparator;

/**
 * 贪心算法：如果区间结尾得越早，后面能够接上一个新区间的概率就越大
 */
public class Solution2 {

    public int eraseOverlapIntervals(Interval[] intervals) {
        int ilen = intervals.length;
        if (ilen == 0) {
            return 0;
        }
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if (o1.end != o2.end) {
                    return o1.end - o2.end;
                }
                return o1.start - o2.start;
            }
        });
        int res = 1;
        int pre = 0;
        for (int i = 1; i < ilen; i++) {
            if (intervals[i].start >= intervals[pre].end) {
                res++;
                pre = i;
            }
        }
        return ilen - res;
    }

    public static void main(String[] args) {
        Interval interval1 = new Interval(1, 2);
        Interval interval2 = new Interval(1, 2);
        Interval interval3 = new Interval(1, 2);
        Interval[] intervals = new Interval[3];
        intervals[0] = interval1;
        intervals[1] = interval2;
        intervals[2] = interval3;

        Solution2 solution2 = new Solution2();
        int eraseOverlapIntervals = solution2.eraseOverlapIntervals(intervals);
        System.out.println(eraseOverlapIntervals);

    }
}
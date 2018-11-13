public class Solution3 {

    public ListNode mergeKLists(ListNode[] lists) {
        int len = lists.length;
        if (len == 0) {
            return null;
        }
        return sort(lists, 0, len - 1);
    }

    public ListNode sort(ListNode[] lists, int l, int r) {
        // 思考这里为什么取等于？这是因为根据下文对 sort 的递归调用情况，区间最窄的时候，只可能是左右端点重合
        if (l == r) {
            return lists[l];
        }
        int mid = (r - l) / 2 + l;
        ListNode l1 = sort(lists, l, mid);
        ListNode l2 = sort(lists, mid + 1, r);
        return merge(l1, l2);
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = merge(l1.next, l2);
            return l1;
        }
        l2.next = merge(l1, l2.next);
        return l2;
    }
}

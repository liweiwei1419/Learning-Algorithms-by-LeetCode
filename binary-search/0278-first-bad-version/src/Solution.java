/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

class VersionControl {
    boolean isBadVersion(int version) {
        // 为了本地编译通过，硬编码
        if (version < 13) {
            return false;
        }
        return true;
    }
}

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (!isBadVersion(mid)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
         int left = 1;
        int right = 0;
        for (int quantity : quantities) {
            right = Math.max(right, quantity);
        }
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canDistribute(n, quantities, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
     private boolean canDistribute(int n, int[] quantities, int x) {
        int storesNeeded = 0;       
        for (int quantity : quantities) {
           storesNeeded += (quantity + x - 1) / x;
        }
         return storesNeeded <= n;
    }
}
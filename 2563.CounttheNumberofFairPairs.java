class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
         Arrays.sort(nums);
        int n = nums.length;
        long count = 0;
        for (int i = 0; i < n - 1; i++) {
            int minJ = lowerBound(nums, i + 1, n - 1, lower - nums[i]);
            int maxJ = upperBound(nums, i + 1, n - 1, upper - nums[i]);
            count += maxJ - minJ + 1;
        }
        
        return count;
    }
     private int lowerBound(int[] nums, int left, int right, int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
    
  
    private int upperBound(int[] nums, int left, int right, int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }
}
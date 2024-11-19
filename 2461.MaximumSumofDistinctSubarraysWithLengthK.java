class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
         int n = nums.length;
        if (k > n) return 0;
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        long maxSum = 0, currentSum = 0;
        int start = 0;
        for (int end = 0; end < n; end++) { 
            freqMap.put(nums[end], freqMap.getOrDefault(nums[end], 0) + 1);
            currentSum += nums[end];
            if (end - start + 1 > k) {
                int leftElement = nums[start];
                freqMap.put(leftElement, freqMap.get(leftElement) - 1);
                if (freqMap.get(leftElement) == 0) {
                    freqMap.remove(leftElement);
                }
                currentSum -= leftElement;
                start++;
            }
            if (end - start + 1 == k && freqMap.size() == k) {
                maxSum = Math.max(maxSum, currentSum);
            }
        }
        return maxSum;
    }
}
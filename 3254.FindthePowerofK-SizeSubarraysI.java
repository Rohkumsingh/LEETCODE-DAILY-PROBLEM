class Solution {
    public int[] resultsArray(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        int n = nums.length;

        for (int i = 0; i < n - k + 1; i++) {
            boolean flag = true;

            for (int j = i; j < i + k - 1; j++) {
                if (nums[j] + 1 != nums[j + 1]) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                result.add(nums[i + k - 1]);
            } else {
                result.add(-1);
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
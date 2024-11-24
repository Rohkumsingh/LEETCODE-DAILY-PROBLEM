class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int n = matrix.length;
        long totalSum = 0;
        int minAbsValue = Integer.MAX_VALUE;
        int negativeCount = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int val = matrix[i][j];
                totalSum += Math.abs(val);
                if (val < 0) negativeCount++;
                minAbsValue = Math.min(minAbsValue, Math.abs(val));
            }
        }

        if (negativeCount % 2 != 0) {
            totalSum -= 2 * minAbsValue;
        }

        return totalSum;  
    }
}

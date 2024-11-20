class Solution {
    public int takeCharacters(String s, int k) {
 if (k == 0) return 0;
        
        int[] totalCount = new int[3];
        for (char c : s.toCharArray()) {
            totalCount[c - 'a']++;
        }
        
        if (totalCount[0] < k || totalCount[1] < k || totalCount[2] < k) {
            return -1;
        }
        
        int n = s.length();
        int[] currentCount = new int[3];
        int maxWindowLength = 0;

        for (int right = 0, left = 0; right < n; right++) {
            currentCount[s.charAt(right) - 'a']++;
            
            while (currentCount[0] > totalCount[0] - k ||
                   currentCount[1] > totalCount[1] - k ||
                   currentCount[2] > totalCount[2] - k) {
                currentCount[s.charAt(left) - 'a']--;
                left++;
            }
            
            maxWindowLength = Math.max(maxWindowLength, right - left + 1);
        }
        
        return n - maxWindowLength;
    }
}
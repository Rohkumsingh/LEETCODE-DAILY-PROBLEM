class Solution {
    private boolean check(int[] banned, int l) {
        for (int i = 0; i < banned.length; i++) {
            if (banned[i] == l) {
                return true;
            }

        }
        return false;
    }

    public int maxCount(int[] banned, int n, int maxSum) {
        int sum = 0;
        int count = 0;
        for (int i = 1; i <= n; i++) {

            if (!check(banned, i)) {
                if(sum+i>maxSum){
                    break;
                }
                sum += i;
                count++;
            }
        }
        return count;
    }
}
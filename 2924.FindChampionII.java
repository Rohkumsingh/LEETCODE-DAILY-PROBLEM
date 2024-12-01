public class 2924.FindChampionII {
    class Solution {
        public int findChampion(int n, int[][] edges) {
            int[] indegree = new int[n];
            for (int[] edge : edges) {
                indegree[edge[1]]++;
            }
            int champion = -1;
            for (int i = 0; i < n; i++) {
                if (indegree[i] == 0) {
                    if (champion == -1) {
                        champion = i; 
                    } else {
                        return -1; 
                    }
                }
            }
    
            return champion; 
        }
    }
}
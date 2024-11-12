class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        Arrays.sort(items, (a, b) -> Integer.compare(a[0], b[0]));
        
        int n = queries.length;
        int[][] queriesWithIndices = new int[n][2];
        for (int i = 0; i < n; i++) {
            queriesWithIndices[i][0] = queries[i];
            queriesWithIndices[i][1] = i; 
        }
    
        Arrays.sort(queriesWithIndices, (a, b) -> Integer.compare(a[0], b[0]));
        
        int[] result = new int[n];
        int maxBeauty = 0; 
        int itemIndex = 0; 
        
        for (int[] query : queriesWithIndices) {
            int queryPrice = query[0];
            int originalIndex = query[1];
            
            while (itemIndex < items.length && items[itemIndex][0] <= queryPrice) {
                maxBeauty = Math.max(maxBeauty, items[itemIndex][1]); 
                itemIndex++;
            }
            
            result[originalIndex] = maxBeauty;
        }
        
        return result;
     
    }
}
class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
         Set<String> wallsSet = new HashSet<>();
        Set<String> guardsSet = new HashSet<>();
        Set<String> guardedSet = new HashSet<>();

        for (int[] wall : walls) {
            wallsSet.add(wall[0] + "," + wall[1]);
        }
        for (int[] guard : guards) {
            guardsSet.add(guard[0] + "," + guard[1]);
        }

        int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        for (int[] guard : guards) {
            int row = guard[0];
            int col = guard[1];

            for (int[] dir : directions) {
                int r = row, c = col;

                while (true) {
                    r += dir[0];
                    c += dir[1];
                    String position = r + "," + c;

                    if (r < 0 || r >= m || c < 0 || c >= n || wallsSet.contains(position) || guardsSet.contains(position)) {
                        break;
                    }

                    guardedSet.add(position);
                }
            }
        }

        int totalCells = m * n;
        int occupiedCells = walls.length + guards.length + guardedSet.size();

        return totalCells - occupiedCells; 
   } 
    
}
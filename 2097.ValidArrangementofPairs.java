class Solution {
    public int[][] validArrangement(int[][] pairs) {
         Map<Integer, Stack<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> inDegree = new HashMap<>();
        Map<Integer, Integer> outDegree = new HashMap<>();

        for (int[] pair : pairs) {
            int start = pair[0];
            int end = pair[1];

            graph.putIfAbsent(start, new Stack<>());
            graph.get(start).push(end);

            outDegree.put(start, outDegree.getOrDefault(start, 0) + 1);
            inDegree.put(end, inDegree.getOrDefault(end, 0) + 1);
        }

        // Step 2: Find starting node for Eulerian path
        int startNode = pairs[0][0]; // Default start node
        for (int node : graph.keySet()) {
            if (outDegree.getOrDefault(node, 0) > inDegree.getOrDefault(node, 0)) {
                startNode = node;
                break;
            }
        }

        // Step 3: Find Eulerian path using Hierholzer's algorithm
        LinkedList<Integer> path = new LinkedList<>();
        dfs(graph, startNode, path);

        // Step 4: Convert path to result
        int[][] result = new int[pairs.length][2];
        int index = 0;
        Iterator<Integer> iterator = path.iterator();
        int prev = iterator.next();
        while (iterator.hasNext()) {
            int curr = iterator.next();
            result[index++] = new int[]{prev, curr};
            prev = curr;
        }

        return result;
    }
      private void dfs(Map<Integer, Stack<Integer>> graph, int node, LinkedList<Integer> path) {
        Stack<Integer> neighbors = graph.get(node);
        while (neighbors != null && !neighbors.isEmpty()) {
            int next = neighbors.pop();
            dfs(graph, next, path);
        }
        path.addFirst(node);
    }
}
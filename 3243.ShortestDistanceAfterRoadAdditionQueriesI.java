public class 3243.ShortestDistanceAfterRoadAdditionQueriesI {
    class Solution {
        public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
            List<List<Integer>> graph=new ArrayList<>();
            for(int i=0;i<n;i++){
                graph.add(new ArrayList<>());
            }
            for(int i=0;i<n-1;i++){
                graph.get(i).add(i+1);
            }
            int[] answer=new int[queries.length];
            for(int q=0;q<queries.length;q++){
                int u=queries[q][0];
                int v=queries[q][1];
                graph.get(u).add(v);
                answer[q]=bfs(graph,n);
            }
            return answer;
        }
        private static int bfs(List<List<Integer>> graph,int n){
            Queue<Integer> queue=new LinkedList<>();
            boolean[] visited=new boolean[n];
            int[] distance=new int[n];
            queue.add(0);
            visited[0]=true;
            while(!queue.isEmpty()){
                int current=queue.poll();
                for(int neighbor : graph.get(current)){
                    if(!visited[neighbor]){
                        visited[neighbor]=true;
                        distance[neighbor]=distance[current]+1;
                        queue.add(neighbor);
                    }
                }
            }
            return visited[n-1] ? distance[n-1]:-1;
        }
    }
}

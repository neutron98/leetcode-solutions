// Topological Sorting
// Time: O(N+E)
// Space: O(N+E)

class Solution1 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // init graph
        int n = numCourses;
        ArrayList<Integer>[] G = new ArrayList[n];
        for (int i = 0; i < n; i++){
            G[i] = new ArrayList<>();
        }
        int[] indegree = new int[n];
        
        for (int[] pair: prerequisites){
            int from = pair[0];
            int to = pair[1];
            G[from].add(to);
            indegree[to]++;
        }
        
        // do the traverse
        Queue<Integer> queue = new LinkedList<>();
        // start with courses of 0 indegree
        for (int i = 0; i < n; i++){
            if (indegree[i] == 0){
                queue.offer(i);
            }
        }
        int numTaken = 0;
        while (!queue.isEmpty()){
            int course = queue.poll();
            // take a course
            numTaken++;
            for (int follow: G[course]){
                // decrease their indegree and check if they equal to 0
                if (--indegree[follow] == 0){
                    queue.offer(follow);
                }
            }
        }
        return (numTaken == n);
    }
}

class Solution {
    public boolean canReach(int[] arr, int start) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[arr.length];
        
        queue.offer(start);
        visited[start] = true;
        
        while (!queue.isEmpty()){
            int pos = queue.poll();
            if (arr[pos] == 0){
                return true;
            }
            if (pos + arr[pos] < arr.length && !visited[pos + arr[pos]]){
                visited[pos + arr[pos]] = true;
                queue.offer(pos + arr[pos]);   
            }
            if (pos - arr[pos] >= 0 && !visited[pos - arr[pos]]){
                visited[pos - arr[pos]] = true;
                queue.offer(pos - arr[pos]);   
            }
        }
        return false;
    }
}

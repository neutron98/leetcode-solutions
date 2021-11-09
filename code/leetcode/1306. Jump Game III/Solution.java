class Solution {
    /***
    
    DFS + memo
    
    [2, 1, 2, ]
    
    ***/

    public boolean canReach(int[] arr, int start) {
        boolean[] visited = new boolean[arr.length];
        return canReach(arr, start, visited);
    }
    private boolean canReach(int[] arr, int start, boolean[] visited){
        if (start < 0 || start >= arr.length){
            return false;
        }
        
        if (arr[start] == 0){
            return true;
        }
        
        if (visited[start]){
            return false;
        }
        
        visited[start] = true;
        
        return canReach(arr, start + arr[start], visited) || canReach(arr, start - arr[start], visited);
    }
}

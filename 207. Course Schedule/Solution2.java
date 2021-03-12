// Backtracking
// O(E + N^2)
// O(E+ N)
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int n = numCourses;
        ArrayList<Integer>[] G = new ArrayList[n];  // course -> {nextCourse1, nextCourse2}
        // construct graph
        for (int course = 0; course < n; course++){
            G[course] = new ArrayList<>();
        }
        
        for (int[] pair: prerequisites){
            G[pair[0]].add(pair[1]);
        }
        
        // if a course is in the visiting path. Used in backtracking
        boolean[] isInPath = new boolean[n];
        
        // if we already checked and confirmed that a course does not have a cycle
        boolean[] confirmedNoCycle = new boolean[n];
        
        for (int course = 0; course < n; course++){
            if (hasCycle(course, G, isInPath, confirmedNoCycle)){ // start from the course to traverse graph
                return false;
            }
        }
        return true;
    }
    
    /**
    * If there is a cycle starting from this course.
    *
    */
    private boolean hasCycle(int course, ArrayList<Integer>[] G, boolean[] isInPath, boolean[] confirmedNoCycle){
        if (isInPath[course]){
            return true;
        }
        
        if (confirmedNoCycle[course]){
            return false;
        }
        
        // otherwise, do traversing using backtracking
        isInPath[course] = true;
        confirmedNoCycle[course] = false;
        
        for (int nextCourse: G[course]){
            if (hasCycle(nextCourse, G, isInPath, confirmedNoCycle)){
                return true;
            }
        }
        
        isInPath[course] = false;
        confirmedNoCycle[course] = true;
        return false;
    }
}

class Solution {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        List<int[]> merged = new ArrayList<>();
        int i = 0, j = 0;
        while (i < A.length && j < B.length){
            /* 
            * if non-overlap, skip(one's start > other end)
            */
            if (A[i][1] < B[j][0]){
                i++;
                continue;
            }
            if (B[j][1] < A[i][0]){
                j++;
                continue;
            }
            /* 
            * overlap (one's start <= other end)
            */
            if (B[j][0] <= A[i][1] || A[i][0] <= B[j][1]){
                int start = Math.max(A[i][0], B[j][0]);
                int end = Math.min(A[i][1], B[j][1]);
                merged.add(new int[]{start, end});
            }
            /* 
            * move pointers
            */
            if (A[i][1] < B[j][1]){
                i++;
            } else{
                j++;
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}

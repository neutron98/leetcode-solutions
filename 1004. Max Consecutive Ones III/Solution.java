class Solution {
    public int longestOnes(int[] A, int K) {
        int l = 0, r;
        int maxLen = 0;
        int repeatOnes = 0;

        for (r = 0; r < A.length; r++){
            if (A[r] == 1){
                repeatOnes++;
            }
            
            if (K + repeatOnes < r - l + 1){  // k: number of zeros can replace
                if (A[l] == 1){
                    repeatOnes--;
                }    
                l++;
            }
            maxLen = Math.max(maxLen, r - l + 1);
        }
        
        return maxLen;
    }
}

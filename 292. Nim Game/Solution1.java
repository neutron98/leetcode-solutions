// O(n), O(n) -> O(1)
// TLE in leetcode
class Solution {
    public boolean canWinNim(int n) {
        if (n == 0){
            return false;
        }
        
        if (n >= 1 && n <= 3){
            return true;
        }
        
        
        boolean[] f = new boolean[n+1];
        f[0] = false;
        f[1] = true;
        f[2] = true;
        f[3] = true;
        for (int i = 4; i <= n; i++){
            f[i] = !f[i-1] || !f[i-2] || !f[i-3];
        }
        return f[n];
    }
}

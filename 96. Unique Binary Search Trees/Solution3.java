// dp
// time complexity: 2 + 3 + ... + n = (n + 2)(n - 1) / 2 = O(n^2)
// space complexity: O(n^2)
class Solution {
    public int numTrees(int n) {
        // G[i] = SUM{F[i, n]}
        // F[i, n] = G[i - 1] * G[n - i]
        // G[i] = SUM{G[i - 1] * G[n - i]}
        int[] G = new int[n + 1];
        G[0] = 1;
        G[1] = 1;
        
        for (int s = 2; s <= n; s++){
            for (int i = 1; i <= s; i++){
                G[s] += G[i - 1] * G[s - i];
            }
        }
        return G[n];
    }
}

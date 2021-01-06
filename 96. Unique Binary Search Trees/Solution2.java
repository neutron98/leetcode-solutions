// recursion + memorization
class Solution {
    Map<Integer, Integer> map = new HashMap<>();
    public int numTrees(int n) {
        if (map.containsKey(n)){
            return map.get(n);
        }
        if (n <= 1) return 1;
        int count = 0;
        for (int i = 1; i <= n; i++) {
            // F(i,n) = G(i−1)⋅G(n−i)
          // making 'i' root of the tree
          int countOfLeftSubtrees = numTrees(i - 1);
          int countOfRightSubtrees = numTrees(n - i);
            // F(i,n) = SUM{G(i−1)⋅G(n−i)}
          count += (countOfLeftSubtrees * countOfRightSubtrees);
        }
        map.put(n, count);
        return count;
    }
}

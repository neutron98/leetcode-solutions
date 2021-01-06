// recursion
// O(catalan), O(catalan)
class Solution {
    public int numTrees(int n) {
    if (n <= 1)
      return 1;
    int count = 0;
    for (int i = 1; i <= n; i++) {
        // F(i,n) = G(i−1)⋅G(n−i)
      // making 'i' root of the tree
      int countOfLeftSubtrees = numTrees(i - 1);
      int countOfRightSubtrees = numTrees(n - i);
        // F(i,n) = SUM{G(i−1)⋅G(n−i)}
      count += (countOfLeftSubtrees * countOfRightSubtrees);
    }
    return count;
    }
}

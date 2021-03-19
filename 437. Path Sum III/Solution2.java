// prefix sum
class Solution {
    
    int target;
    int count = 0;
    Map<Integer, Integer> prefixCount = new HashMap<>();
    
    public int pathSum(TreeNode root, int sum) {
        target = sum;
        traverse(root, 0);
        return count;
        
    }
    
    private void traverse(TreeNode root, int currSum){
        if (root == null){
            return;
        }
        
        
        currSum += root.val;
            
        // situation 1: from top to node i
        if (currSum == target){
            count++;
        }
        // situation 2: from node i to node j
        count += prefixCount.getOrDefault(currSum - target, 0);
        
        // add currSum count
        prefixCount.put(currSum, prefixCount.getOrDefault(currSum, 0) + 1);
        
        traverse(root.left, currSum);
        traverse(root.right, currSum);
        
        // backtrack in order not to use it during the parallel subtree processing
        prefixCount.put(currSum, prefixCount.get(currSum) - 1);
    }
}

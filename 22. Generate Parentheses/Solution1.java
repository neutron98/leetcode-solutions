// recursive
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> results = new ArrayList<>();
        helper(results, "", 0, 0, n);
        return results;
    }
    
    private void helper(List<String> results, String curr,
                        int leftCount, int rightCount, int n){
        if (leftCount + rightCount == 2 * n){
            results.add(curr);
            return;
        }
        
        if (leftCount < n){
            helper(results, curr + "(", leftCount + 1, rightCount, n);
        }
        
        if (rightCount < leftCount){
            helper(results, curr + ")", leftCount, rightCount + 1, n);
        }
    }
}

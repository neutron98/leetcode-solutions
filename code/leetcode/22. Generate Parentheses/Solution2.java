// iterative, like BFS
// O(N * 2^N), O(N * 2^N)
class ParenthesesString{
    String str;
    int leftCount;
    int rightCount;
    ParenthesesString(String s, int leftCount, int rightCount){
        this.str = s;
        this.leftCount = leftCount;
        this.rightCount = rightCount;
    }
}

class Solution {

    public List<String> generateParenthesis(int n) {
        List<String> results = new ArrayList<>();
        Queue<ParenthesesString> queue = new LinkedList<>();
        queue.offer(new ParenthesesString("", 0, 0));
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++){
                ParenthesesString ps = queue.poll();
                if (ps.leftCount + ps.rightCount == n * 2){
                    results.add(ps.str);
                } else{
                    if (ps.leftCount < n){
                        queue.offer(new ParenthesesString(ps.str + "(", ps.leftCount + 1, ps.rightCount));
                    }
                    if (ps.rightCount < ps.leftCount){
                        queue.offer(new ParenthesesString(ps.str + ")", ps.leftCount, ps.rightCount + 1));
                    }
                }
            }
        }
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

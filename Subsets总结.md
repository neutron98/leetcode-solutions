**1. Subsets**  O(2^n)


```
Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
```


需要start index,但是不需要visited，也不需要backtrack。因为每次是向后取的，不会重复取到前面的元素。
下一次dfs调用从i+1开始。


```java
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        
        helper(0, nums, new ArrayList<>(), results);
        return results;
    }
    
    private void helper(int start, int[] nums, List<Integer> subset,
                        List<List<Integer>> results){
        
        results.add(new ArrayList<Integer>(subset));
        
        for (int i = start; i < nums.length; i++){
            subset.add(nums[i]);
            helper(i + 1, nums, subset, results);
            subset.remove(subset.size() - 1);
        }
    }
}
```

去重方法：

```java
        if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]){
            continue;
        }

```


**2. Permutations** O(n!)
```
Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
```

不需要start index，需要visited，需要backtrack。因为每次从头开始取的。


```java
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        List<List<Integer>> results = new ArrayList<>();
        
        helper(nums, visited, new ArrayList<>(), results);
        return results;
    }
    
    private void helper(int[] nums, boolean[] visited, List<Integer> subList, 
                        List<List<Integer>> results){
        if (subList.size() == nums.length){
            results.add(new ArrayList<>(subList));
            return;
        }
        
        for (int i = 0; i < nums.length; i++){
            if (visited[i]){
                continue;
            }
            visited[i] = true;
            subList.add(nums[i]);
            
            helper(nums, visited, subList, results);
            
            visited[i] = false;
            subList.remove(subList.size() - 1);
        }
        
    }
    
}
```

去重方法：

```java
        if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]){
            continue;
        }
```

**3. Combination Sum**


每个数可以用多次：
```
Input: candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]]
```
需要index，不需要visited，需要backtrack。并且下一次dfs调用还是从i开始。

```java
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        if (candidates == null || candidates.length == 0){
            return results;
        }
        List<Integer> subList = new ArrayList<>();
        Arrays.sort(candidates);
        

        dfs(candidates, 0, subList, results, target);
        
        return results;
    }
    
    /**
    @param candidates
    @param index        index of current num in candiadates
    @param subList      stores current sublist
    @param results
    @param target       target to achieve along current path
    
    */
    private void dfs(int[] candidates, int index, List<Integer> subList,
                    List<List<Integer>> results, int target){
        
        if (target == 0){
            results.add(new ArrayList<Integer>(subList));
            return;
        }
        for (int i = index; i < candidates.length; i++){
             if (candidates[i] > target){
                break;
            }
            
            subList.add(candidates[i]);
            dfs(candidates, i, subList, results, target - candidates[i]);
            subList.remove(subList.size() - 1);
        }
    }
}
```

如果每个数只能用一次：(Combination Sum II)。

需要index，不需要visited，需要backtrack。
下一次dfs从i+1开始，并且循环内如果nums[i] == nums[i-1]要跳过。

```java
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        if (candidates == null || candidates.length == 0){
            return results;
        }
        List<Integer> subList = new ArrayList<>();
        Arrays.sort(candidates);
        

        dfs(candidates, 0, subList, results, target);
        
        return results;
    }
    
    /**
    @param candidates
    @param index        index of current num in candiadates
    @param subList      stores current sublist
    @param results
    @param target       target to achieve along current path
    
    */
    private void dfs(int[] candidates, int index, List<Integer> subList,
                    List<List<Integer>> results, int target){
        
        if (target == 0){
            results.add(new ArrayList<Integer>(subList));
            return;
        }
        for (int i = index; i < candidates.length; i++){
            if (i > index && candidates[i] == candidates[i - 1]){
                continue;
            }
            
             if (candidates[i] > target){
                break;
            }
            
            subList.add(candidates[i]);
            dfs(candidates, i + 1, subList, results, target - candidates[i]);
            subList.remove(subList.size() - 1);
        }
    }

}
```

4. Letter Combinations of a Phone Number

```
Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
```
每次针对一个digits里的数，dfs所有letter。需要backtrack。
下一次从下一个digit取。用stringbuilder。

```java
class Solution {
    
    private Map<Character, String> map = Map.of(
        '2', "abc", '3', "def", '4', "ghi", '5', "jkl", 
        '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz");
    
    public List<String> letterCombinations(String digits) {
        
        List<String> results = new ArrayList<>();
        if (digits == null || digits.isEmpty()){
            return results;
        }
        
        dfs(digits, 0, new StringBuilder(), results);
        
        return results;
    }
    
    private void dfs(String digits, int index, StringBuilder builder, 
                    List<String> results){
        if (index == digits.length()){
            results.add(builder.toString());
            return;
        }
        
        char currDigit = digits.charAt(index);
        
        for (char c: map.get(currDigit).toCharArray()){
            builder.append(c);
            dfs(digits, index + 1, builder, results);
            builder.setLength(builder.length() - 1);
        }
    }
}
```

**5. Generate Parenthesis**

核心是rightCount不超过leftCount。
用StringBuilder的话需要backtrack。

```
Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]
```

```java
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        
        helper(0, 0, new StringBuilder(), result, n);
        
        return result;
    }
    
    private void helper(int leftCount, int rightCount, StringBuilder builder,
                       List<String> result, int n){
        if (leftCount + rightCount == 2 * n){
            result.add(builder.toString());
            return;
        }
        
        if (leftCount < n){
            builder.append("(");
            helper(leftCount + 1, rightCount, builder, result, n);
            builder.setLength(builder.length() - 1);
        }
        
        if (rightCount < leftCount){
            builder.append(")");
            helper(leftCount, rightCount + 1, builder, result, n);
            builder.setLength(builder.length() - 1);
        }
    }
}
```


**6.N-Queens**
```java
class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> results = new ArrayList<>();
        
        if (n <= 0){
            return results;
        }
        
        int[] positions = new int[n]; // col index in each row
        
        solve(0, positions, n, results);
        
        return results;
    }
    
    private void solve(int r, int[] positions, int n, List<List<String>> results){
        if (r == n){
            List<String> board = drawBoard(positions);
            results.add(board);
            return;
        }
        
        for (int col = 0; col < n; col++){
            if (!isValid(r, col, positions, n)){
                continue;
            }
            
            positions[r] = col;
            solve(r + 1, positions, n, results);
        }
    }
    
    private boolean isValid(int row, int col, int[] positions, int n){
        for (int i = 0; i < row; i++){
            int j = positions[i];
            
            if (j == col){
                return false;
            }
            
            if (col - j == row - i){
                return false;
            }
            
            if (col - j == i - row){
                return false;
            }
        }
        
        return true;
    }
    
    private List<String> drawBoard(int[] positions){
        int n = positions.length;
        List<String> board = new ArrayList<>();
        for (int i = 0; i < n; i++){
            StringBuilder builder = new StringBuilder();
            for (int j = 0; j < n; j++){
                builder.append('.');
            }
            builder.setCharAt(positions[i], 'Q');
            board.add(builder.toString());
        }
        
        return board;
    }
}
```

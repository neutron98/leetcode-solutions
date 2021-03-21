class Solution {
    // O(4^n)
    // O(N)
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

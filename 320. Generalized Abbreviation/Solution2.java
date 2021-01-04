// backtracking

class Solution {
    public List<String> generateAbbreviations(String word) {
        List<String> results = new ArrayList<>();
        backtrack(word, new StringBuilder(), results, 0, 0);
        return results;
    }
    
    private void backtrack(String word, StringBuilder builder, 
                          List<String> results, int curr, int count){
        int len = builder.length(); // keep the length of builder
        
        if (curr == word.length()){
            if (count != 0){
                builder.append(count);
            }
            results.add(builder.toString());
        } else{
            // B(1) -> B(2)
            backtrack(word, new StringBuilder(builder), results, curr + 1, count + 1);
            if (count != 0){
                builder.append(count);
            }
                builder.append(word.charAt(curr));
                backtrack(word, builder, results, curr + 1, 0);
            
        }
        builder.setLength(len); // reset builder to the original state
        
    }
}

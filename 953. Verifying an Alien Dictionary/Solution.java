// key idea: 给for循环命名
// O(C), C is total number of chars
// O(1)

class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] positions = new int[26];  // char-> pos
        // equals to HashMap<Character, Integer>
        for (int i = 0; i < order.length(); i++){
            int cInt = order.charAt(i) - 'a';
            positions[cInt] = i;
        }
        
        boolean sorted = true;
        searchWord: for (int i = 1; i < words.length; i++){  // for each word
            String currWord = words[i];
            String prevWord = words[i - 1];
            
            for (int k = 0; k < Math.min(currWord.length(), prevWord.length()); k++){// traverse characters
                int currPos = positions[currWord.charAt(k) - 'a'];
                int prevPos = positions[prevWord.charAt(k) - 'a'];
                
                if (currPos < prevPos){
                    return false;
                } else if (currPos == prevPos){  // >=
                    continue;
                } else{
                    continue searchWord;
                }
            }
        
            if (prevWord.length() > currWord.length()){
                return false;
            }
        }
        return true;
    }
}
                

// O(MN), O(n)
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> resultIndices = new ArrayList<Integer>();
        Map<String, Integer> wordFreq = new HashMap<>();
        for (String word: words){
          wordFreq.put(word, wordFreq.getOrDefault(word, 0) + 1);
        }

        int numWords = words.length; 
        int wordLen = words[0].length();
        for (int i = 0; i <= s.length() - numWords * wordLen; i++){
          Map<String, Integer> wordsSeen = new HashMap<>();
          for (int j = 0; j < numWords; j++){
              int nextWordIndex = i + j * wordLen;
              //find current word
              String word = s.substring(nextWordIndex, nextWordIndex + wordLen);
              if (!wordFreq.containsKey(word)){  // if not contained, break
                break;
              }
               wordsSeen.put(word, wordsSeen.getOrDefault(word, 0) + 1); // add the word to the 'wordsSeen' map
              // if is an redundant word, break
              if (wordsSeen.get(word) > wordFreq.getOrDefault(word, 0)){
                break;
              }
              if (j == numWords - 1){  // if we matched all words
                resultIndices.add(i);
              }
          }
        }
        return resultIndices;
    }
}

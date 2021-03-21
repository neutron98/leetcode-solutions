// Using hashset
// O(m + n) 实际上O(mn)
// O(m + n) 

class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        // 1). replace the punctuations with spaces,
        // and put all letters in lower case
        
        String str = paragraph.replaceAll("[^a-zA-Z0-9 ]", " ").toLowerCase();
        
        String[] words = str.split("\\s+");
        Set<String> bannedWords = new HashSet<>();
        for (String word: banned){
            bannedWords.add(word);
        }
        Map<String, Integer> map = new HashMap<>();
        for (String word: words){
            if (!bannedWords.contains(word)){
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }
        
        return Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getKey();
    }
}

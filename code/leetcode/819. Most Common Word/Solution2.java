class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        // 1). replace the punctuations with spaces,
        // and put all letters in lower case
        
        String str = paragraph.replaceAll("[^a-zA-Z0-9 ]", " ").toLowerCase();
        
        String[] words = str.split("\\s+");

        Map<String, Integer> map = new HashMap<>();
        for (String word: words){
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        for (String word: banned){
            map.put(word, 0);
        }
        return Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getKey();
    }
}

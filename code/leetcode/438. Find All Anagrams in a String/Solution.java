class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int matched = 0;
        Map<Character, Integer> freq = new HashMap<>();
        for (char c: p.toCharArray()){
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        
        
        int l = 0, r;
        for (r = 0; r < s.length(); r++){
            char rightChar = s.charAt(r);
            if (freq.containsKey(rightChar)){
                freq.put(rightChar, freq.get(rightChar) - 1);
                if (freq.get(rightChar) == 0){
                    matched++;
                }
            }
            
            if (matched == freq.size()){
                result.add(l);
            }
            
            if (r - l + 1 >= p.length()){
                char leftChar = s.charAt(l);
                if (freq.containsKey(leftChar)){
                    if (freq.get(leftChar) == 0){
                        matched--;
                    }
                    freq.put(leftChar, freq.get(leftChar) + 1);
                }
                l++;
            }
        }
        
        return result;
    }
}

// Bit Manipulation

class Solution {
    public List<String> generateAbbreviations(String word) {
        List<String> results = new ArrayList<>();
        int n = word.length();
        for (int s = 0; s < (1 << n); s++){
            results.add(abbr(word, s));
        }
        return results;
    }
    
    private String abbr(String word, int s){
        StringBuilder builder = new StringBuilder();
        int count = 0, n = word.length();
        for (int i = 0; i < n; i++){
            if (((s >> i) & 1) == 1){// bit is one, abbreviate word.charAt(i)
                count++;
            } else{
                if (count != 0){
                    builder.append(count);
                }
                count = 0;
                builder.append(word.charAt(i));
            }
        }
        //don't forget to append the last k if non zero
        if (count != 0){
            builder.append(count);
        }
        return builder.toString();
    }
}

// BFS
// O (N*2^N), O (N*2^N)

class AbbreviatedWord{
    StringBuilder builder;
    int start;
    int count;
    AbbreviatedWord(StringBuilder builder, int start, int count){
        this.builder = builder;
        this.start = start;
        this.count = count;
    }
}
class Solution {
    public List<String> generateAbbreviations(String word) {
        int n = word.length();
        List<String> results = new ArrayList<>();
        Queue<AbbreviatedWord> queue = new LinkedList<>();
        queue.offer(new AbbreviatedWord(new StringBuilder(), 0, 0));
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++){
                AbbreviatedWord abWord = queue.poll();
                if (abWord.start == n){
                    if (abWord.count != 0){   // B(2) -> B2
                        abWord.builder.append(abWord.count);
                    }
                    results.add(abWord.builder.toString());
                } else{
                    // B(1) -> B(2)
                    queue.offer(new AbbreviatedWord(new StringBuilder(abWord.builder), abWord.start + 1, abWord.count + 1));
                    
                    
                    if (abWord.count != 0){ // B(1) -> B1
                        abWord.builder.append(abWord.count);
                    }
                    
                    // B1 -> B1T
                    queue.offer(new AbbreviatedWord(new StringBuilder(abWord.builder).append(word.charAt(abWord.start)), abWord.start + 1, 0));
                }
            }
        }
        return results;
    }
}

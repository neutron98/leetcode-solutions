class Solution {
    public int leastInterval(char[] tasks, int n) {
        /* The idea is to use some frequent tasks to fulfill as many idle slots as one could.
         (1) The most frequent task is not frequent enough to force the presence of idle slots.
             
             ["A","A","A","A", B","C","D","E", "F", "G", "H", "I", "J"] n = 2
             [A, B, E]   [A, C, F]  [A, D, H]  [A, I, J] 
        
         (2) The most frequent task is too frequent that other tasks cannot fill the groiup
         
            ["A","A","A","B","B","B"], n = 2
             [A, B, /]   [A, B,/]  [A, B, ]
             
            a group has {n + 1} slots
            
            we have {k} groups, and need {k - 1} idles 
            
            Assume our most frequent task is "A", and:
            freq(A) = k >= freq(B) >= freq(B) >= ... >= freq(Z). {p} tasks has the same freq as A
         
         */
        int[] frequencies = new int[26];
        
        for (char c: tasks){
            int charVal = c - 'A';
            frequencies[charVal]++;
        }
        // count number of most frequent chars
        int maxFreq = 0;
        for (int freq: frequencies){
            maxFreq = Math.max(maxFreq, freq);
        }
        
        int p = 0;
        for (int i = 0; i < 26; i++){
            if (frequencies[i] == maxFreq){
                p++;
            }
        }
        
        int ans1 = (maxFreq - 1) * (n + 1) + p;
        
        int ans2 = tasks.length;
        return Math.max(ans1, ans2);
        
    }
}

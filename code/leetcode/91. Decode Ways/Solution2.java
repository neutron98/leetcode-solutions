// 类似滚动数组的降维。O(n), O(1)
class Solution {
    public int numDecodings(String s) {
        if(s == null || s.length() == 0 || s.charAt(0) == '0') return 0;
        // test cases:
        
        // [2]    -> 1
        // [12]   -> 2
        // [170]  -> 0
        // [1070] -> 0
        // [200] -> 0
        // [201] -> 0
        // [2627]
        
        // 1. last step :
        
        
        // 2. transition function:
        // f[i] number of ways to decode i chars 
        // f[i] = f[i-1] (when {i-1} is valid) + f[i-2] (when {i-2, i-1} is valid)
        // f[i] = 0 if both one-digit number and two-digit number are invalid
        
        // 3. initial state and edge cases
        // f[0] = 1
        
        // 1710
        
        // 
        
        int n = s.length();
        int w1 = 1; // f[i-1]
        int w2 = 1;  // f[i-2]

        for (int i = 1; i < n; i++){ // from 1 to i. When i = 0, will return 1
            int w = 0; // f[i]
            if (!isValid(s.charAt(i)) && !isValid(s.charAt(i-1), s.charAt(i))){
                return 0;
            }
            if (isValid(s.charAt(i))){
                w += w1;
            }
            if (isValid(s.charAt(i-1), s.charAt(i))){
                w += w2;
            }
            
            // f[i-2] = f[i-1]
            // f[i-1] = f[i]
            w2 = w1;
            w1 = w;
            
        }
        
        return w1;
    }
    
    
    private boolean isValid(char c){
        return (c != '0');
    }
    
    private boolean isValid(char c1, char c2){
        int number =  (c1 - '0') * 10 + (c2 - '0');
        
        return (number >= 10 && number <= 26);
    }
}

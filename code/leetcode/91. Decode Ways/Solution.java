// O(n), O(n)

class Solution {
    public int numDecodings(String s) {
        // 1. last step
        // the last number must take the last 1 or 2 digits
        
        // 2. transition function
        // f[i]: # of ways to decode i chars (from i-1 to i-1)
        // f[i] = f[i-1] (when s[i-1] is a char)
        //      + f[i-2]  (when s[i-1][i-2] is a char)
        
        // 3. initial stats and edge cases:
        // f[0] = 1. There is only one way to decode 0 to 0
        // i >= 1
        
        // 4. Computing order
        // f[1]f[2] ... f[n]
        
        int n = s.length();
        int[] f = new int[n+1];  // must be n+1
        // otherwise, cases cannot pass: "12", "10"
        f[0] = 1;
        
        for (int i = 1; i <= n; i++){

            char oneDigitVal = s.charAt(i-1);
            
            if (oneDigitVal > '0'){ // if is an valid digit
                f[i] += f[i-1];
            }
            if (i > 1 && s.charAt(i-2) != '0'){ // 01 x
                int twoDigitVal = Integer.parseInt(s.substring(i-2, i)); // s[i-2, i-1]
                if (twoDigitVal < 27){
                    f[i] += f[i-2];
                }
            }
        }
        
        return f[n];
        
    }
}

// using stack:
// O(maxK * n)
// O(n)
class Solution {
    public String decodeString(String s) {
        /**
        "13[ab2[cd]]""
                   |
        
        count: 2
        currStr: cd 
        
        countStack: 2, 13
        strStack:  ab
        
        
        
        1. if curr char is a digit(0-9), append it to {count}
        
        2. if curr char is a letter(a-z), append it to {currStr}
        
        3. if curr char is a '[', push {count} to countStack, reset count; 
            push {currStr} to strStack, reset currStr
        
        
        4. if curr char is a ']', start decoding:
            
            pop from countStack: {count}
            
            (1) construct the string as {str2}: currStr * count   (2[cd] -> cdcd)
            (2) pop another string as {str1} from strStack, and join: tempStr = str1 + str2      (abcdcd)
        
            currStr = tempStr
        **/
        
        if (s == null || s.length() == 0){
            return "";
        }
        
        int count =  0;
        StringBuilder currStr = new StringBuilder();
        
        Stack<Integer> countStack = new Stack<>();
        Stack<String> strStack = new Stack<>();
        
        for (int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            
            if (Character.isDigit(ch)){
                count = 10 * count + (ch - '0');
            } else if (Character.isLetter(ch)){
                currStr.append(ch);
            } else if (ch == '['){
                countStack.push(count);
                count = 0; // reset
                
                strStack.push(currStr.toString());
                currStr.setLength(0); // reset
            } else{ // ']'
                int currCount = countStack.pop();
                StringBuilder str2 = new StringBuilder();
                while (currCount-- > 0){
                    str2.append(currStr);
                }
                
                currStr.setLength(0);
                currStr.append(strStack.pop()).append(str2);
            }
        }
        
        return currStr.toString();
    }
}

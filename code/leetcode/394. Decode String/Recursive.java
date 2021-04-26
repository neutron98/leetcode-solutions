class Solution {
    int index = 0;
    public String decodeString(String s) {
        if (s == null || s.length() == 0){
            return "";
        }
        
        StringBuilder builder = new StringBuilder();
        while (index < s.length() && s.charAt(index) != ']'){
            if (!Character.isDigit(s.charAt(index))){
                builder.append(s.charAt(index++));
            } else{
                int count = 0;
                while (index < s.length() && Character.isDigit(s.charAt(index))){
                    count = count * 10 + (s.charAt(index++) - '0');
                }          
                // ignore the opening bracket '['    
                index++;
                String decodedString = decodeString(s);
                // ignore the closing bracket ']'
                index++;
                
                while (count-- > 0){
                    builder.append(decodedString);
                }
            }
        }
        
        return builder.toString();
    }
}

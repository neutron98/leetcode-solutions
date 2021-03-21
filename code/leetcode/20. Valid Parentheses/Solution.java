class Solution {
    public boolean isValid(String s) {
        if (s == null || s.length() % 2 == 1){
            return false;
        }
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        Stack<Character> stack = new Stack<>();
        for (char c: s.toCharArray()){
            if (map.containsKey(c)){  // right parenthesis
                if (stack.empty() || map.get(c) != stack.pop()){
                    return false;
                }
            } else{ // left parenthesis
                stack.push(c);
            }
        }
        
        return stack.empty();
    }
}

// Recursion with memorization

class Solution {
    Map<String, List<Integer>> resultMap = new HashMap<>();
    public List<Integer> diffWaysToCompute(String input) {
        if (resultMap.containsKey(input)){
            return resultMap.get(input);
        }
        
        List<Integer> result = new ArrayList<>();
        // base case: if the input string is a number, parse and add it to output
        if (!input.contains("+") && !input.contains("-") && !input.contains("*")){
            result.add(Integer.parseInt(input));
        } else {
            for (int i = 0; i < input.length(); i++){
                // () + (), () - (), () * ()
                char ch = input.charAt(i);
                if (!Character.isDigit(ch)){// if it is an operator
                    List<Integer> leftParts = diffWaysToCompute(input.substring(0, i));
                    List<Integer> rightParts = diffWaysToCompute(input.substring(i + 1));  // should not include i
                    for (int part1: leftParts){
                        for (int part2: rightParts){
                            if (ch == '+'){
                                result.add(part1 + part2);
                            } else if (ch == '-'){
                                result.add(part1 - part2);
                            } else if (ch == '*'){
                                result.add(part1 * part2);
                            }
                        }
                    }
                    
                }
            }
        }
        resultMap.put(input, result);
        return result;
    } 
}

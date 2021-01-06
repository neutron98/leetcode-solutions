// Recursion
// 想象优先级高（括号内）的expression在子节点，后计算的在上面的节点
// 那么就类似于n个节点的二叉树有多少种形态（Catalan数）
// 时间和空间都是O(Catalan)

class Solution {
    public List<Integer> diffWaysToCompute(String input) {
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
        return result;
    } 
}

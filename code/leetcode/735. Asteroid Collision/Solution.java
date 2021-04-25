class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        
       
        Stack<Integer> stack = new Stack<>();
        
        int i = 0;  // index
        
        int n = asteroids.length;
        
        for (int ast: asteroids){
            
            /**
            [-2, -1, 4 , 2, -3, -4]
                            |
                            
            [-2, -1, 1, 2, ]
            
                        **/
            
            collision: {
                while (!stack.isEmpty() && ast < 0 && stack.peek() > 0){
                    if (stack.peek() < -ast){
                        stack.pop();
                    } else if (stack.peek() == -ast){
                        stack.pop();
                        break collision;
                    } else{
                        break collision;
                    }
                }
                stack.push(ast);
            }
        }

        
        int[] result = new int[stack.size()];
        int j = result.length - 1;
        while (j >= 0){
            result[j--] = stack.pop(); 
        }
        
        return result;
    }
}

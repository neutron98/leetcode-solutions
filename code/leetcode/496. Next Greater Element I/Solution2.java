class Solution {
    // monotonic stack. O(M+N)
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // https://www.youtube.com/watch?v=8BDKB2yuGyg

        
        Map<Integer, Integer> nextGreater = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        
        for (int num: nums2){
            //如果num是当前栈顶元素的greater element
            // 用while loop的原因: nums2 = [8, 7, 6, 5, 10]
            while (!stack.isEmpty() && num > stack.peek()){
                //存入map
                nextGreater.put(stack.pop(), num);
            }
            stack.push(num);
        }
        
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++){
            if (!nextGreater.containsKey(nums1[i])){
                res[i] = -1;
            } else{
                res[i] = nextGreater.get(nums1[i]);
            }
        }
        
        return res;
    }
}

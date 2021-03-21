// Built in function
// O(N+M)

// 2 draw backs
class Solution {
    public String addBinary(String a, String b) {
        return Integer.toBinaryString(Integer.parseInt(a, 2) + 
                                     Integer.parseInt(b, 2));
    }
}

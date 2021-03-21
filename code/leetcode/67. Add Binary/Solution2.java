// O(max(N,M))
// O(max(N,M))
class Solution {
    public String addBinary(String a, String b) {
        int n1 = a.length();
        int n2 = b.length();
        int p1 = n1 - 1, p2 = n2 - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while (p1 >= 0 || p2 >= 0){
            int val1 = (p1 >= 0) ? a.charAt(p1) - '0' : 0;
            int val2 = (p2 >= 0) ? b.charAt(p2) - '0' : 0;
            int val = (val1 + val2 + carry) % 2;
            carry = (val1 + val2 + carry) / 2;
            sb.append(val);
            p1--;
            p2--;
        }
        
        if (carry != 0){
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
}

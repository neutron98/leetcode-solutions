// bit manipulation
// O(M+N)
// O(max(N,M))
import java.math.BigInteger;
class Solution {
    public String addBinary(String a, String b) {
        BigInteger x = new BigInteger(a, 2);
        BigInteger y = new BigInteger(b, 2);
        BigInteger zero = new BigInteger("0", 2);
        BigInteger carry, ansWithoutCarry;
        while (y.compareTo(zero) != 0){
            ansWithoutCarry = x.xor(y);
            carry = x.and(y).shiftLeft(1);
            x = ansWithoutCarry;
            y = carry;
        }
        
        return x.toString(2);
    }
}

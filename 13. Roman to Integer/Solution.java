class Solution {
    static Map<String, Integer> values = new HashMap<>();

     static {
        values.put("M", 1000);
        values.put("D", 500);
        values.put("C", 100);
        values.put("L", 50);
        values.put("X", 10);
        values.put("V", 5);
        values.put("I", 1);
    }   
    public int romanToInt(String s) {
        int sum = 0;
        int n = s.length();
        int i = 0;
        while (i < n){
            String curr = s.substring(i, i + 1);
            int currVal = values.get(curr);
            int nextVal = 0;
            if (i + 1 < n){
                String next = s.substring(i + 1, i + 2);
                nextVal = values.get(next);
            }
            if (currVal < nextVal){
                sum += (nextVal - currVal);
                i += 2;
            } else{
                sum += currVal;
                i += 1;
            }
        }
        return sum;
    }
}

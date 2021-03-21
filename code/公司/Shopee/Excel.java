public class Excel {
    public static String columnByNum(int num){
        if(num <= 0)
            return "";

        StringBuilder sb = new StringBuilder("");

        int mod = 0;

        // 28
        while(num > 0)
        {
            num--;              // 27            0
            mod = num % 26;     // mod = 1    // "A"
            sb.append((char)('A' + mod));    // "B"     "BA"
            num /= 26;          // 1  0
        }

        return sb.reverse().toString();
    }

    public static int numByColumn(String column){

        char[] arr = column.toCharArray();
        int num = 0;
        for (int i = 0; i < arr.length; i++){
            num = num * 26;

            char c = arr[i];
            int diff = c - 'A';
            diff++;

            num += diff;
        }

        return num;
    }


    public static void main(String[] args){
        Assert.assertEquals(columnByNum(28), "AB");
        Assert.assertEquals(numByColumn("AB"), 28);
        
        Assert.assertEquals(columnByNum(26), "Z");
        Assert.assertEquals(numByColumn("Z"), 26);

    }

}

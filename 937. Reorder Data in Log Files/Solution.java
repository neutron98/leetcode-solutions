class Solution {
    public String[] reorderLogFiles(String[] logs) {
        Comparator<String> comp = new Comparator<String>(){
            @Override
            public int compare(String log1, String log2){
                String[] split1 = log1.split(" ", 2);
                String[] split2 = log2.split(" ", 2);
                
                boolean startDigit1 = Character.isDigit(split1[1].charAt(0));
                boolean startDigit2 = Character.isDigit(split2[1].charAt(0));
                
                // both letter-logs or digit logs
                if (!startDigit1 && !startDigit2){
                    int contentComp = split1[1].compareTo(split2[1]);
                    if (contentComp != 0){
                        return contentComp;
                    } else{
                        return split1[0].compareTo(split2[0]);
                    }
                } else if (!startDigit1 && startDigit2){
                    return -1;
                } else if (startDigit1 && !startDigit2){
                    return 1;
                } else{
                    return 0;
                }
            }
        };
                               
        Arrays.sort(logs, comp);
        return logs;
    }
}

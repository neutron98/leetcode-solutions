class Solution {
    public boolean backspaceCompare(String S, String T) {
        int index1 = S.length() - 1, index2 = T.length() - 1;
        while (index1 >= 0 || index2 >= 0){
            int v1 = getNextValidCharIndex(S, index1);
            int v2 = getNextValidCharIndex(T, index2);
            if (v1 < 0 && v2 < 0){
                return true;
            }
            if (v1 < 0 || v2 < 0){
                return false;
            }
            if (S.charAt(v1) != T.charAt(v2)){
                return false;
            }
            index1 = v1 - 1;
            index2 = v2 - 1;
        }
        return true;
    }
    
    private int getNextValidCharIndex(String str, int index){
        // cases: ab#c, abab###c, ab#a#bc
        // count backspace, serving like a stack
        int countbackspace = 0;
        while (index >= 0){
            if (str.charAt(index) == '#'){
                countbackspace++;
            } else if (countbackspace > 0){
                countbackspace--;
            } else{
                break;
            }
            index--;
        }
        return index;
    }
}

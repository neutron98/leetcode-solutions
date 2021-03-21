class Solution {
    // key idea: when visiting each row, stop at the empty element
    // time: O(R*C) -> O(n)
    // space: O(n)
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        List<List<Integer>> m = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < nums.size(); i++){  // left -> right
            for (int j = 0; j < nums.get(i).size(); j++){  // top -> down
                int key = i + j;
                if (key == m.size()){ // if the diagonal list does not have this sublist
                    m.add(new ArrayList<>());
                }
                m.get(key).add(nums.get(i).get(j));  // for each element in this row, add them to the right place
                count++;
            }
        }
        
        int[] results = new int[count];
        int index = 0;
        for (List<Integer> diagonalList : m){
            for (int i = diagonalList.size() - 1; i >= 0; i--){
                results[index++] = diagonalList.get(i); 
            }
        }
        return results;
    }
}

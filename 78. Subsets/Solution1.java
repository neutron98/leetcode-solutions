// BFS
// add a number to all current sets
// O(N * 2^N), O(N * 2^N)
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        results.add(new ArrayList<>());
        for (int currNumber : nums){
            int size = results.size();
            for (int i = 0; i < size; i++){
                List<Integer> subset = new ArrayList<>(results.get(i));
                subset.add(currNumber);
                results.add(subset);
            }
        }
        return results;
    }
}

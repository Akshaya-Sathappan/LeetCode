class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> resultLists = new ArrayList<>();
        backtrack(resultLists, new ArrayList<>(), nums, 0);
        return resultLists;
    }

    public void backtrack(List<List<Integer>> resultLists, List<Integer> tempSet, int[] nums, int start){

        resultLists.add(new ArrayList<>(tempSet));

        for(int i = start; i < nums.length; i++){

            tempSet.add(nums[i]);

            backtrack(resultLists, tempSet, nums, i + 1);

            tempSet.remove(tempSet.size() - 1);
        }
    }
}
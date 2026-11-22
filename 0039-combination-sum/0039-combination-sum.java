class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        findCombinations(result, candidates, target, 0, new ArrayList<>());
        return result;
    }

    public void findCombinations(List<List<Integer>> result, int[] candidates, int target, int index, List<Integer> temp){
        if(index == candidates.length){
            if(target == 0){
                result.add(new ArrayList<>(temp));
            }
            return;
        }

        if(candidates[index] <= target){
            temp.add(candidates[index]);
            findCombinations(result, candidates, target - candidates[index], index, temp);
            temp.remove(temp.size() - 1);
        }

        findCombinations(result, candidates, target, index + 1, temp);
    }
}
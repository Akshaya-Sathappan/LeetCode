class Solution {
    public int sumOfUnique(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int sum = 0;
        for(int i : nums){
            map.put(i, map.getOrDefault(i, 0)+1);
        }
        for(int j : nums){
            if(map.get(j)==1){
                sum+=j;
            }
        }
        return sum;
    }
}
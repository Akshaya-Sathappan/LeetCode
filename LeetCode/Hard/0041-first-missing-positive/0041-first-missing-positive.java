class Solution {
    public int firstMissingPositive(int[] nums) {
        boolean[] arr = new boolean[nums.length + 2];

        for(int n : nums){
            if(n >= 1 && n <= nums.length){
                arr[n] = true;
            }
        }

        for(int i = 1; i <= nums.length + 1; i++){
            if(arr[i] == false){
                return i;
            }
        }
        return 0;
    }
}
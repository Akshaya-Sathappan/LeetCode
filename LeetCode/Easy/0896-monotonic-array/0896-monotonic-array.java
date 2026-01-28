class Solution {
    public boolean isMonotonic(int[] nums) {
        boolean asc = false;
        boolean desc = false;

        for(int i = 1; i < nums.length; i++){
            if(nums[i] > nums[i-1]){
                asc = true;
            }
            else if(nums[i] < nums[i-1]){
                desc = true;
            }

            if(asc && desc){
                return false;
            }
        }
        return true;
    }
}
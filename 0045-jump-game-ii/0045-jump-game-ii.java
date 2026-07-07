class Solution {
    public int jump(int[] nums) {
        if(nums.length == 1) return 0;
        int right = nums[0];
        int noOfJumps = 1;
        for(int left = 1; left < nums.length; left++){
            if(right < left + nums[left]){
                right = left + nums[left];
                noOfJumps++;
            }
            if(right >= nums.length - 1){
                return noOfJumps;
            }
        }
        return noOfJumps;
    }
}
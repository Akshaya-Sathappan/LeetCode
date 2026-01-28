class Solution {
    public boolean canJump(int[] nums) {
        int maxIndex = 0;
        int i = 0;

        for(int num : nums){
            if(i > maxIndex){
                return false;
            }
            maxIndex = Math.max(maxIndex, i + num);
            i++;
            if(maxIndex >= nums.length - 1){
                return true;
            }
        }
        return false;
    }
}
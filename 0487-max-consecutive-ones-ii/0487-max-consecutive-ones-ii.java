class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int left = 0;
        int maxOnes = 0;
        int noOfZeroes = 0;

        for(int right = 0; right < nums.length; right++){
            if(nums[right] == 0){
                noOfZeroes++;
            }

            while(noOfZeroes > 1){
                if(nums[left] == 0){
                    noOfZeroes--;
                }
                left++;
            }

            maxOnes = Math.max(maxOnes, right - left + 1);
        }

        return maxOnes;
    }
}
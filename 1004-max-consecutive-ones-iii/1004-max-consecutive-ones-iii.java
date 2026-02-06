class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0;
        int length = 0;
        int noOfZeroes = 0;

        for(int right = 0; right < nums.length; right++){
            if(nums[right] == 0){
                noOfZeroes++;
            }

            while(noOfZeroes > k){
                if(nums[left] == 0){
                    noOfZeroes--;
                }
                left++;
            }
            length = Math.max(length, right - left + 1);
        }
        return length;
    }
}
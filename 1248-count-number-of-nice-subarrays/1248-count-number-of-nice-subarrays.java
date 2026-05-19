class Solution {
    public int numberOfSubarrays(int[] nums, int k){
        return atMost(nums, k) - atMost(nums, k - 1);
    }
    public int atMost(int[] nums, int k) {
        int oddCount = 0;
        int left = 0;
        int niceCount = 0;

        for(int right = 0; right < nums.length; right++){
            if(nums[right] % 2 != 0){
                oddCount++;
            }

            while(oddCount > k){
                if(nums[left++] % 2 != 0){
                    oddCount--;
                }
            }

            niceCount += right - left + 1;
        }
        return niceCount;
    }
}
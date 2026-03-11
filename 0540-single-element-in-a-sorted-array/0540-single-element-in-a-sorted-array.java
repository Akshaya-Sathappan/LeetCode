class Solution {
    public int singleNonDuplicate(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        while(low < high){
            int mid = (low + high)/2;
            mid = (mid % 2) == 0 ? mid : mid - 1;

            if(nums[mid] == nums[mid + 1]){
                low = mid + 2;
            }
            else{
                high = mid;
            }
        }
        return nums[low];
    }
}
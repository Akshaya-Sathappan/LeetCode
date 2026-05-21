class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int start = -1;
        int end = -1;

        while(left <= right){
            int mid = (left + right)/2;

            if(nums[mid] == target){
                start = mid;
                right = mid - 1;
            }

            else if(nums[mid] < target){
                left = mid + 1;
            }

            else{
                right = mid - 1;
            }
        }

        int left2 = 0;
        int right2 = nums.length - 1;

        while(left2 <= right2){
            int mid = (left2 + right2)/2;

            if(nums[mid] == target){
                end = mid;
                left2 = mid + 1;
            }

            else if(nums[mid] < target){
                left2 = mid + 1;
            }

            else{
                right2 = mid - 1;
            }
        }

        return new int[]{start, end};
    }
}
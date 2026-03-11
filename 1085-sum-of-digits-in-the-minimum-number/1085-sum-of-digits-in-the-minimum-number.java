class Solution {
    public int sumOfDigits(int[] nums) {
        int mini = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] < mini){
                mini = nums[i];
            }
        }

        int sum = 0;

        while(mini > 0){
            int rem = mini % 10;
            sum += rem;
            mini = mini/10;
        }

        return (sum % 2) == 0 ? 1 : 0;
    }
}
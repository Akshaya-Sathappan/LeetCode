class Solution {
    public int maxProduct(int[] nums) {
        /*int max = 0;
        for(int i = 0; i<nums.length-1; i++){
            for(int j = i+1; j<nums.length; j++){
                int sum = (nums[i]-1)*(nums[j]-1);
                if(sum > max){
                    max = sum;
                }
            }
        }
        return max;*/

        Arrays.sort(nums);
        int i = nums.length - 1;
        int j = nums.length - 2;
        int result = (nums[i]-1)*(nums[j]-1);
        return result;
    }
}
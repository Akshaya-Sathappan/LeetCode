class Solution {
    public int maximumCount(int[] nums) {
        int i = 0;
        int neg = 0;
        int pos = 0;
        while(i < nums.length){
            if(nums[i]<0){
                neg++;
            }
            else if(nums[i]>0){
                pos++;
            }
            i++;
        }
        return Math.max(neg, pos);
    }
}
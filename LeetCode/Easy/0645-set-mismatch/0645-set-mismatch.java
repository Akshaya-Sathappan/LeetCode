class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int num = 0;
        int asum = 0;
        Arrays.sort(nums);
        for(int i=0; i<n-1; i++){
            asum += nums[i];
            if(nums[i]==nums[i+1]){
                num = nums[i];
            }
        }
        int esum = n * (n+1)/2;
        asum = asum + nums[n-1];
        int mnum = esum - (asum - num);
        return new int[] {num, mnum};
    }
}
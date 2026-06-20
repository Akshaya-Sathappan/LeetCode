class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1;
        int high = Integer.MIN_VALUE;
        int result = 0;

        for(int num : nums){
            high = Math.max(high, num);
        }

        while(low <= high){
            int mid = (low + high)/2;
            int val = sum(mid, nums);

            if(val <= threshold){
                result = mid;
                high = mid - 1;
            }

            else{
                low = mid + 1;
            }
        }

        return result;
    }

    public int sum(int n, int[] nums){
        int ans = 0;
        for(int num : nums){
            ans += Math.ceil((1.0 * num) / n);
        }
        return ans;
    }
}
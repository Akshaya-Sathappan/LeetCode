class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxBananas = 0;

        for(int p : piles){
            maxBananas = Math.max(maxBananas, p);
        }

        int low = 1;
        int high = maxBananas;
        int ans = 0;

        while(low <= high){
            int mid = (low + high)/2;

            if(noOfHours(mid, piles) > h){
                low = mid + 1;
            }

            else{
                ans = mid;
                high = mid - 1;
            }
        }
        return ans;
    }

    private int noOfHours(int i, int[] piles){
        int totalHours = 0;

        for(int j : piles){
            totalHours += Math.ceil((double)j/(double)i);
        }

        return totalHours;
    }
}
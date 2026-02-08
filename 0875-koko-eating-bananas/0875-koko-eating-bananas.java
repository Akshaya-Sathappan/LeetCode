class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = findMax(piles);
        int ans = 0;

        while(low <= high){
            int mid = (low + high)/2;
            int totalHrs = totalHrs(piles, mid);

            if(totalHrs <= h){
                ans = mid;
                high = mid - 1;
            }

            else{
                low = mid + 1;
            }
        }
        return ans;
    }

    private int findMax(int[] piles){
        int maxi = Integer.MIN_VALUE;
        for(int i = 0; i < piles.length; i++){
            maxi = Math.max(piles[i], maxi);
        }
        return maxi;
    }

    private int totalHrs(int[] piles, int hourlyBananas){
        int totalHrs = 0;
        for(int i = 0; i < piles.length; i++){
            totalHrs += Math.ceil((double)piles[i]/(double)hourlyBananas);
        }
        return totalHrs;
    }
}
class Solution {

    int[] prefixSum;
    int total;
    Random rand;

    public Solution(int[] w) {
        rand = new Random();
        prefixSum = new int[w.length];
        prefixSum[0] = w[0];
        for(int i = 1; i < w.length; i++){
            prefixSum[i] = prefixSum[i - 1] + w[i];
        }

        total = prefixSum[w.length - 1];
    }
    
    public int pickIndex() {
        int random = rand.nextInt(total) + 1;
        int left = 0;
        int right = prefixSum.length - 1;

        while(left < right){
            int mid = left + (right - left)/2;

            if(prefixSum[mid] < random){
                left = mid + 1;
            }
            else{
                right = mid;
            }
        }
        return left;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
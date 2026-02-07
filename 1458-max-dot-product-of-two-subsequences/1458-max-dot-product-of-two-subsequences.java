class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int n = nums1.length; 
        int m = nums2.length;

        long[] prev = new long[m + 1];
        long[] cur = new long[m + 1];

        long neg = Long.MIN_VALUE;

        Arrays.fill(prev, neg);

        for(int i = 1; i <= n; i++){
            Arrays.fill(cur, neg);
            for(int j = 1; j <= m; j++){
                long prod = (long) nums1[i - 1] * nums2[j - 1];
                long take = prod;

                if(prev[j - 1] != neg){
                    take = Math.max(take, prev[j - 1] + prod);
                }

                long skip1 = prev[j];

                long skip2 = cur[j - 1];

                cur[j] = Math.max(take, Math.max(skip1, skip2));
            }

            long[] temp = prev;
            prev = cur;
            cur = temp;
        }
        return (int)prev[m];
    }
}
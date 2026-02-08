class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes,(a, b) -> (a[0] == b[0]) ? b[1] - a[1] : a[0] - b[0]);
        int[] lis = new int[envelopes.length];
        int size = 0;

        for(int i = 0; i < envelopes.length; i++){
            int h = envelopes[i][1];
            int left = 0;
            int right = size;

            while(left < right){
                int mid = (left + right)/ 2;

                if(lis[mid] < h){
                    left = mid + 1;
                }
                else{
                    right = mid;
                }
            }

            lis[right] = h;

            if(right == size) size++;
        }
        return size;
    }
}
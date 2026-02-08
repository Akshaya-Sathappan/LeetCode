class Solution {
    public int[] lexSmallestNegatedPerm(int n, long target) {
        long total = (long) n * (n + 1)/2;

        if(Math.abs(target) > total || (total - target) % 2 != 0){
            return new int[]{};
        }

        long need = (total - target)/2;
        boolean[] neg = new boolean[n + 1];
        int[] result = new int[n];

        for(int i = n; i > 0 && need > 0; i--){
            if(need >= i){
                neg[i] = true;
                need -= i;
            }
        }

        int idx = 0;
        for(int i = n; i > 0; i--){
            if(neg[i]){
                result[idx++] = -i;
            }
        }
        for(int i = 1; i <= n; i++){
            if(!neg[i]){
                result[idx++] = i;
            }
        }
        return result;
    }
}
class Solution {
    public int mirrorDistance(int n) {
        int n1 = n;
        int sum = 0;
        while(n > 0){
            int rem = n % 10;
            sum = rem + (sum * 10);
            n = n / 10;
        }

        return Math.abs(n1 - sum);
    }
}
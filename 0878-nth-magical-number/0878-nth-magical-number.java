class Solution {
    public int nthMagicalNumber(int n, int a, int b) {
        long low = Math.min(a, b);
        long high = (long) n * Math.min(a, b);
        long lcm = (long) (a / gcd(a, b)) * b;

        while(low < high){
            long mid = low + (high - low)/2;
            if(mid/a + mid/b - mid/lcm < n){
                low = mid + 1;
            }
            else{
                high = mid;
            }
        }
        return (int) (low % 1000000007);
    }

    public int gcd(int a, int b){
        if(b == 0) return a;
        return gcd(b, a % b);
    }
}
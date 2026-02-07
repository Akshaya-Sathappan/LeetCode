class Solution {
    public int maximumLength(int[] nums) {
       int odd = 0;
       int even = 0;

       for(int num : nums){
        if(num % 2 == 0){
            even++;
        }
        else{
            odd++;
        }
       } 

       int alt = 1;
       int prevParity = nums[0] % 2;

       for(int i = 1; i < nums.length; i++){
        int curParity = nums[i] % 2;
        if(curParity != prevParity){
            alt++;
            prevParity = curParity;
        }
       }
       return Math.max(Math.max(odd, even), alt);
    }
}
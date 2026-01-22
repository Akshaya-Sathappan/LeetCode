class Solution {
    public boolean checkPerfectNumber(int num) {
        int result = 0;
        for(int i = 1; i <= num/2; i++){
            if(num%i == 0){
                result += i;
            }
        }
        return num == result ? true : false;
    }
}
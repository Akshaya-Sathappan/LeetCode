class Solution {
    public String intToRoman(int num) {
        String[] roman = {
            "M", "CM", "D", "CD",
            "C", "XC", "L", "XL",
            "X", "IX", "V", "IV", "I"
        };

        int[] value = {
            1000, 900, 500, 400,
            100, 90, 50, 40,
            10, 9, 5, 4, 1
        };

        StringBuilder res = new StringBuilder();

        for(int i = 0; i < value.length; i++){
            int count = 0;
    
            count = num / value[i];
            num = num % value[i];
            while(count > 0){
                res.append(roman[i]);
                count--;
            }

            if(num == 0) break;
            
        }
        return res.toString();
    }
}
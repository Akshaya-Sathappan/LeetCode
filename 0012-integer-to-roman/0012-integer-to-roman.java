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

        int count = 0;
        StringBuilder result = new StringBuilder();

        for(int i = 0; i < value.length; i++){
            count = num / value[i];
            num = num % value[i];

            while(count > 0){
                result.append(roman[i]);
                count--;
            }
            if(num == 0) break;
        }
        return result.toString();
    }
}
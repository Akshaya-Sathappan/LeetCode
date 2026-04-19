class Solution {
    public int romanToInt(String s) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("IV", 4);
        map.put("V", 5);
        map.put("IX", 9);
        map.put("X", 10);
        map.put("XL", 40);
        map.put("L", 50);
        map.put("XC", 90);
        map.put("C", 100);
        map.put("CD", 400);
        map.put("D", 500);
        map.put("CM", 900);
        map.put("M", 1000);

        int i = 0;
        int sum = 0;
        while(i < s.length()){
            if(i < s.length()-1){
                String doubleStr = s.substring(i, i+2);
                if(map.containsKey(doubleStr)){
                    sum += map.get(doubleStr);
                    i += 2;
                    continue;
                }
            }
            
            String singleStr = s.substring(i, i+1);
            sum += map.get(singleStr);
            i++;
            
        }
        return sum;
    }
}
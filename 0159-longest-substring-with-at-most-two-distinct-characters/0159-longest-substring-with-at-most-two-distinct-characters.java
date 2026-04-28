class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        int maxLength = 0;
        int len = s.length();

        if(len < 3){
            return len;
        }

        for(int right = 0; right < len; right++){
            char r = s.charAt(right);
            map.put(r, map.getOrDefault(r, 0) + 1);
            while(map.size() > 2){
                char l = s.charAt(left);
                map.put(l, map.get(l) - 1);
                if(map.get(l) == 0)
                    map.remove(l);
                left++;        
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
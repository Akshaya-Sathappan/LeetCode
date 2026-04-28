class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        int len = s.length();
        int maxLen = 0;
        int left = 0;

        for(int right = 0; right < s.length(); right++){
            char r = s.charAt(right);
            map.put(r, map.getOrDefault(r, 0) + 1);

            while(map.size() > k){
                char l = s.charAt(left);
                map.put(l, map.getOrDefault(l, 0) - 1);
                if(map.get(l) == 0){
                    map.remove(l);
                }
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}
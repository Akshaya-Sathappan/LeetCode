class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        int maxLength = 0;

        for(int right = 0; right < s.length(); right++){
            while(map.containsKey(s.charAt(right))){
                if(map.get(s.charAt(left)) != 0){
                    map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                    if(map.get(s.charAt(left)) == 0)
                        map.remove(s.charAt(left));
                    left++;
                }
            }

            map.put(s.charAt(right), 1);
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
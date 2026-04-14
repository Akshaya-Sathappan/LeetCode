class Solution {
    public boolean wordPattern(String pattern, String s) {
        HashMap map = new HashMap();
        String[] words = s.split(" ");

        if(words.length != pattern.length()){
            return false;
        }

        for(Integer i = 0; i < words.length; i++){
            if(!map.containsKey(words[i])){
                map.put(words[i], i);
            }

            if(!map.containsKey(pattern.charAt(i))){
                map.put(pattern.charAt(i), i);
            }

            if(map.get(words[i]) != map.get(pattern.charAt(i))){
                return false;
            }
        }
        return true;
    }
}
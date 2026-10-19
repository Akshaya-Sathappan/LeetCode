class Solution {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        char[] ch = s.toCharArray();

        for(char c : ch){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        HashSet<Character> set = new HashSet<>();
        int start = 0;
        int current = 0;
        List<Integer> result = new ArrayList<>();

        for(char c : ch){
            current++;
            if(map.get(c) == 1){
                map.remove(c);
                set.remove(c);
            }
            else{
                map.put(c, map.get(c) - 1);
                set.add(c);
            }

            if(set.isEmpty()){
                result.add(current - start);
                start = current;
            }
        }

        return result;
    }
}
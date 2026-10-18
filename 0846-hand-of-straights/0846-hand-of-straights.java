class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        TreeMap<Integer, Integer> map = new TreeMap<>();

        if((hand.length % groupSize) != 0) return false;

        for(int i = 0; i < hand.length; i++){
            map.put(hand[i], map.getOrDefault(hand[i], 0) + 1);
        }

        while(!map.isEmpty()){
            int start = map.firstKey();

            for(int i = start; i < start + groupSize; i++){
                if(!map.containsKey(i)){
                    return false;
                }

                if(map.get(i) == 1){
                    map.remove(i);
                }
                else{
                    map.put(i, map.get(i) - 1);
                }
            }
        }

        return true;
    }
}
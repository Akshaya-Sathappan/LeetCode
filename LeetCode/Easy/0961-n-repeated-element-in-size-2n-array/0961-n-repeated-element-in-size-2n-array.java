class Solution {
    public int repeatedNTimes(int[] nums) {
        /*HashMap<Integer,Integer> map = new HashMap<>();
        int res = 0;

        for(int num : nums){
            map.put(num, map.getOrDefault(num,0)+1);
        }

        for(Map.Entry<Integer,Integer> i : map.entrySet()){
            if(i.getValue().equals(nums.length/2)){
                res = i.getKey();
            }
        }
        return res; */
        
        HashSet<Integer> set = new HashSet<>();
        int n = 0;

        for(int i : nums){
            if(!set.contains(i)){
                set.add(i);
            }
            else{
                n = i;
                break;
            }
        }
        return n;
    }
}
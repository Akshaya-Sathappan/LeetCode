class Solution {
    public int thirdMax(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for( int i : nums){
            set.add(i);
        }
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        if(list.size() < 3){
            return list.get(list.size()-1);
        }
        else{
            return list.get(list.size()-3);
        }
    }
}
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        for(int num : nums1){
            set.add(num);
        }
        for(int num2 : nums2){
            if(set.contains(num2)){
                list.add(num2);
                set.remove(num2);
            }
        }
        return list.stream().mapToInt(i->i).toArray();
    }
}
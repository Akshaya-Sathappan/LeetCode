class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int num : nums1){
            list.add(num);
        }
        ArrayList<Integer> result = new ArrayList<>();
        for(int num2 : nums2){
            if(list.contains(num2)){
                list.remove(Integer.valueOf(num2));
                result.add(num2);
            }
        }

        int[] arr = new int[result.size()];
        for(int i = 0; i < result.size(); i++){
            arr[i] = result.get(i);
        }
        return arr;
    }
}
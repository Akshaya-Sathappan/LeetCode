class Solution {
    public int findKthPositive(int[] arr, int k) {
        HashSet<Integer> set = new HashSet<>();
        for(int num : arr){
            set.add(num);
        }

        int i = 0;
        int num = 0;
        while(i < k){
            num++;
            if(!set.contains(num)){
                i++;
            }
        }
        return num;
    }
}
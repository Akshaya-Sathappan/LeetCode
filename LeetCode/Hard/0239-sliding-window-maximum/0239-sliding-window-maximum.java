class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] arr = new int[nums.length - k + 1];

        for(int i = 0; i < nums.length; i++){
            if(!stack.isEmpty() && stack.peekFirst() <= i - k){
                stack.pollFirst();
            }

            while(!stack.isEmpty() && nums[stack.peekLast()] < nums[i]){
                stack.pollLast();
            }

            stack.add(i);

            if(i >= k - 1){
                arr[i - k + 1] = nums[stack.peekFirst()];
            }
        }
        return arr;
    }
}
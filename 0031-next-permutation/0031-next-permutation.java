class Solution {
    public void nextPermutation(int[] nums) {
        int index = -1;
        for(int i = nums.length - 2; i >= 0; i--){
            if(nums[i] < nums[i + 1]){
                index = i;
                break;
            }
        }

        if(index == -1){
            Arrays.sort(nums);
        }
        else{
            for(int j = nums.length - 1; j > index; j--){
                if(nums[j] > nums[index]){
                    swap(nums, index, j);
                    break;
                }
            }
            reverse(nums, index + 1);
        }
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int i){
        int j = nums.length - 1;
        while(i < j){
            swap(nums, i, j);
            i++;
            j--;
        }
    }
}
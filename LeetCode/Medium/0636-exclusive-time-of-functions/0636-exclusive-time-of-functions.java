class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        Deque<Integer> stack = new ArrayDeque<>();
        int prevTime = 0;
        int[] result = new int[n];

        for(String str : logs){
            String[] arr = str.split("\\:");
            int fn = Integer.parseInt(arr[0]);
            String s = arr[1];
            int time = Integer.parseInt(arr[2]);

            if(s.equals("start")){
                if(!stack.isEmpty()){
                    result[stack.peek()] += time - prevTime;
                }
                stack.push(fn);
                prevTime = time;
            }
            else{
                result[stack.pop()] += time - prevTime + 1;
                prevTime = time + 1;
            }
        }
        return result;
    }
}
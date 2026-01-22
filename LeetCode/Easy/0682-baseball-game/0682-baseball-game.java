class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();
        int sum = 0;
        for(int i=0; i<operations.length; i++){
            if(operations[i].equals("C")){
                stack.pop();
            }
            else if(operations[i].equals("D")){
                int n = stack.peek();
                stack.push(n*2);
            }
            else if(operations[i].equals("+")){
                int first = stack.pop();
                int second = stack.peek();
                int third = second + first;
                stack.push(first);
                stack.push(third);
            }
            else{
                stack.push(Integer.parseInt(operations[i]));
            }
        }
        for(int k : stack){
            sum+=k;
        }
        return sum;
    }
}
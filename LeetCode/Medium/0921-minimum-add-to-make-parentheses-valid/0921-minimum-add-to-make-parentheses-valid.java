class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();
        int count = 0;
        for(char ch : s.toCharArray()){
            if(ch == '('){
                stack.push(ch);
                count++;
            }
            else if(ch == ')' && !stack.isEmpty()){
                stack.pop();
                count--;
            }
            else{
                count++;
            }
        }
        return count;
    }
}
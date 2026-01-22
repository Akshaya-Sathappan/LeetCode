class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        char[] ch = s.toCharArray();
        for(char c : ch){
            if(c == '(' || c =='{' || c == '['){
                stack.push(c);
            }
            else if(c == ')'){
                if(!stack.isEmpty() && stack.pop() == '(')
                    continue;
                else
                    return false;    
            }
            else if(c == '}'){
                if(!stack.isEmpty() && stack.pop() == '{')
                    continue;
                else
                    return false;    
            }
            else if(c == ']'){
                if(!stack.isEmpty() && stack.pop() == '[')
                    continue;
                else
                    return false;    
            }
        }
        if(!stack.isEmpty())
            return false;
        return true;
    }
}
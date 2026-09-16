class Solution {
    public boolean checkValidString(String s) {
        Deque<Integer> openStack = new ArrayDeque<>();
        Deque<Integer> aestrikStack = new ArrayDeque<>();
        char[] ch = s.toCharArray();

        for(int i = 0; i < ch.length; i++){
            if(ch[i] == '('){
                openStack.push(i);
            }
            else if(ch[i] == '*'){
                aestrikStack.push(i);
            }
            else{
                if(!openStack.isEmpty()){
                    openStack.pop();
                }
                else if(!aestrikStack.isEmpty()){
                    aestrikStack.pop();
                }
                else{
                    return false;
                }
            }
        }
        while(!openStack.isEmpty()){
            if(!aestrikStack.isEmpty() && aestrikStack.peek() > openStack.peek()){
                aestrikStack.pop();
                openStack.pop();
            }
            else{
                return false;
            }
        }
        return true;
    }
}

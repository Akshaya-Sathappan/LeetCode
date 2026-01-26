class Solution {
    public String removeDuplicates(String s, int k) {
        Deque<Pair> stack = new ArrayDeque<>();
        StringBuilder str = new StringBuilder();

        for(int i = 0; i < s.length(); i++){
            if(!stack.isEmpty() && stack.peek().ch == s.charAt(i)){
                stack.peek().count++;
                if(stack.peek().count == k){
                    stack.pop();
                }
            }
            else{
                stack.push(new Pair(s.charAt(i), 1));
            }
        }
        while(!stack.isEmpty()){
            for(int i = 1; i <= stack.peek().count; i++){
                str.append(stack.peek().ch);
            }
            stack.pop();
        }
        str.reverse();
        return str.toString();
    }
}

class Pair{
    char ch;
    int count;

    Pair(char ch, int count){
        this.ch = ch;
        this.count = count;
    }
}
class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();

        for(String str : tokens){
            if(str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/")){
                int a = stack.pop();
                int b = stack.pop();

                switch(str){
                    case "+" : stack.push(b + a); break;
                    case "-" : stack.push(b - a); break;
                    case "*" : stack.push(b * a); break;
                    case "/" : stack.push(b / a); break;
                }
            }

            else{
                stack.push(Integer.parseInt(str));
            }
        }
        return stack.pop();
    }
}
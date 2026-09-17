class Solution {
    public String simplifyPath(String path) {
        Deque<String> stack = new ArrayDeque<>();
        String[] parts = path.split("/");
        StringBuffer str = new StringBuffer();

        for(String s : parts){
            if(s.equals("..")){
                if(!stack.isEmpty())
                    stack.pop();
            }
            else if(s.isEmpty() || s.equals(".")){
                continue;
            }
            else{
                stack.push(s);
            }
        }

        while(!stack.isEmpty()){
            str.append('/');
            str.append(stack.removeLast());
        }

        return str.length() == 0 ? "/" : str.toString();
    }
}
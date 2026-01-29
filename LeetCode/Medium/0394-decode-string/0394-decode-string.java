class Solution {
    public String decodeString(String s) {
        Deque<String> strStack = new ArrayDeque<>();
        Deque<Integer> numStack = new ArrayDeque<>();
        String str = "";
        int num = 0;

        for(char c : s.toCharArray()){

            if(Character.isDigit(c)){
                num = num * 10 + (c - '0');
            }

            else if(c == '['){
                numStack.push(num);
                strStack.push(str);

                str = "";
                num = 0;
            }

            else if(c == ']'){
                int repeat = numStack.pop();
                String prev = strStack.pop();

                StringBuilder sb = new StringBuilder(prev);

                for(int i = 0; i < repeat; i++){
                    sb.append(str);
                }

                str = sb.toString();
            }

            else{
                str += c;
            }
        }
        return str;
    }
}
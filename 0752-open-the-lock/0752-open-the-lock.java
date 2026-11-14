class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> visited = new HashSet<>();
        Set<String> deadend = new HashSet<>();
        
        for(String s : deadends){
            deadend.add(s);
        }

        if (deadend.contains("0000")) {
            return -1;
        }

        Queue<String> q = new ArrayDeque<>();
        q.offer("0000");
        visited.add("0000");
        int turns = 0;

        while(!q.isEmpty()){
            int size = q.size();

            for(int i = 0; i < size; i++){
                String s = q.poll();

                if(s.equals(target)){
                    return turns;
                }

                char[] ch = s.toCharArray();

                for(int j = 0; j < 4; j++){
                    int digit = ch[j] - '0';

                    ch[j] = (char)('0' + (digit + 1) % 10);

                    String forward = new String(ch);

                    if(!deadend.contains(forward) && !visited.contains(forward)){
                        q.offer(forward);
                        visited.add(forward);
                    }

                    ch[j] = (char)('0' + (digit + 9) % 10);

                    String backward = new String(ch);

                    if(!deadend.contains(backward) && !visited.contains(backward)){
                        q.offer(backward);
                        visited.add(backward);
                    }

                    ch[j] = (char) ('0' + digit);
                }
            }

            turns++;
        }

        return -1;
    }
}
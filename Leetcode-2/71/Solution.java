import java.util.LinkedList;
import java.util.Deque;
class Solution {
    public String simplifyPath(String path) {
        Deque<String> queue = new LinkedList<>();

        String[] res = path.split("/");
        for(int i = 0; i < res.length; i++){
            String s = res[i];
            if(s.equals(".") || s.equals("")) continue;
            else if(s.equals("..")){
                if(!queue.isEmpty()){
                    queue.pollLast();
                }
            }else{
                queue.offer(s);
            }
        }
        StringBuilder sb = new StringBuilder("/");
        while(!queue.isEmpty()){
            sb.append(queue.poll());
            if(!queue.isEmpty()){
                sb.append("/");
            }
        }
        return sb.toString().equals("") ? "/" : sb.toString();

    }
}
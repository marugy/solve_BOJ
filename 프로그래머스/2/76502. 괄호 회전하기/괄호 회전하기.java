import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        String[] arr = s.split("");
        ArrayList<String> list = new ArrayList<>();
        for(String str : arr) list.add(str);
        
        for(int i=0; i<s.length(); i++){
            String tmp = list.remove(0);
            list.add(tmp);

            Stack<String> stack = new Stack<>();
            for(int j=0; j<list.size(); j++){
                if(stack.size()==0) stack.push(list.get(j));
                else if(stack.peek().equals("(") && list.get(j).equals(")")) stack.pop();
                else if(stack.peek().equals("[") && list.get(j).equals("]")) stack.pop();
                else if(stack.peek().equals("{") && list.get(j).equals("}")) stack.pop();
                else stack.push(list.get(j));
            }

            if(stack.size()==0) answer++;
        }
        return answer;
    }
}
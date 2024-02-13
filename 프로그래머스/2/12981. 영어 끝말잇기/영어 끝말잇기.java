import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        
        int[] answer = new int[2];
        int[] turn = new int[n];
        turn[0]++;
        
        int player = 1;
        
        Stack<String> stack = new Stack<>();
        stack.push(words[0]);
        
        for(int i=1; i<words.length; i++){
            String before = stack.peek();
            if(!stack.contains(words[i]) &&before.substring(before.length()-1).equals(words[i].substring(0,1))){
                    stack.push(words[i]);
                    turn[player++]++;
                    player%=n;
            }else{
                answer[0]=player+1;
                answer[1]=turn[player]+1;
                return answer;
            }
        }
        return answer;
    }
}
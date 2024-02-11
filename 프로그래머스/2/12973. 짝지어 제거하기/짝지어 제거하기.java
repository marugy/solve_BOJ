import java.util.*;
class Solution{
    public int solution(String s){
        char[] arr = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for(int i=0; i< arr.length ; i++){
            if(stack.size()==0 || stack.peek()!=arr[i]){
                stack.push(arr[i]);
            }else{
                stack.pop();
            }
        }
        if(stack.size()>0) return 0;
        return 1;
    }
}
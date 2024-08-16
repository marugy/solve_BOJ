import java.util.*;
class Solution {
    public String[] solution(String myString) {
        String[] arr = myString.split("x");
        ArrayList<String> list = new ArrayList<>();
        for(String str: arr){
            if(!str.equals(""))list.add(str);
        }
        String[]answer = new String[list.size()];
        for(int i=0;i<answer.length; i++){
            answer[i] = list.get(i);
        }
        Arrays.sort(answer);
        return answer;
    }
}
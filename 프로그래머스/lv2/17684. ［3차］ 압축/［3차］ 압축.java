import java.util.*;

class Solution {
    
    static HashMap<String, Integer> dictionary = new HashMap<>();
    public int[] solution(String msg) {
        
        ArrayList<Integer> deque = new ArrayList<>(); 
        
        //사전에 추가
        for(int i='A'; i<='Z'; i++){
            dictionary.put(Character.toString(i),i-'A'+1);
        }
        int dicSize = 27;
        int maxLength = 1;
        
        String[] arr = msg.split("");
        
        for(int i=0; i<arr.length; i++){
            //검사할 문자열
            String str = arr[i];
            String tmp = str;
            int j = i+1;
            //사전에 있을때까지 반복
            while(dictionary.get(str)!=null){
                tmp = str; //현재 글자
                if(j==arr.length) break;
                str = str + arr[j++];//사전 추가 글자
            }
            deque.add(dictionary.get(tmp));
            i = i + tmp.length() - 1;
            dictionary.put(str,dicSize++);
            
            if(tmp.equals(str)) break;
        }   
        
        
        
        int[] answer = new int[deque.size()];
        for(int i=0; i< deque.size(); i++){
            answer[i] = deque.get(i);
        }
        
        return answer;
    }
}
import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i=0; i<completion.length; i++){
            if(map.containsKey(completion[i])){
                map.replace(completion[i], map.get(completion[i])+1);
            }else{
                map.put(completion[i],1);
            }
        }
        
        for(int i=0; i< participant.length; i++){
            if(map.containsKey(participant[i])){
                if(map.get(participant[i])>=2){
                    map.replace(participant[i], map.get(participant[i])-1);
                }else{
                    map.remove(participant[i]);
                }
            }else{
                return participant[i];
            }
        }
        return "";
    }
}
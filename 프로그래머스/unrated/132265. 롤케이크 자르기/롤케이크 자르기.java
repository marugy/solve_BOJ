import java.util.*;

class Solution {
    public int solution(int[] topping) {
        
        int answer = 0;
        
        HashSet<Integer> setA = new HashSet<>();
        HashSet<Integer> setB = new HashSet<>();
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i=0; i< topping.length; i++){
            
            if(map.get(topping[i])==null){
                map.put(topping[i], 1);
            }else{
                map.put(topping[i], map.get(topping[i])+1);
            }
            setB.add(topping[i]);
        }
        
        for(int i=0;i<topping.length; i++){
            
            if(map.get(topping[i])>1){
                map.put(topping[i], map.get(topping[i])-1);
            }else{
                map.remove(topping[i]);
                setB.remove(topping[i]);
            }
            setA.add(topping[i]);
            
            if(setA.size()==setB.size()){
                answer++;
            }
        }
        

        return answer;
    }
}
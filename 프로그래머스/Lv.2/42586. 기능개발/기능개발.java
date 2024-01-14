import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        ArrayList<Integer> array = new ArrayList<>();
        
        int day=0;
        int progress = 0;
        for(int i=0;i<progresses.length; i++){
            
            progresses[i] += day*speeds[i];
            if(progresses[i]>=100){
                progress++;
                continue;
            }
            if(progress!=0){
                array.add(progress);
                progress=0;
            }
            while(progresses[i]<100){
                progresses[i]+=speeds[i];
                day++;
            }
            progress++;
        }
        if(progress!=0){
            array.add(progress);
        }
        
        int []answer = new int[array.size()];
        for(int i=0; i<array.size();i++)
            answer[i]=array.get(i);
        return answer;
    }
}
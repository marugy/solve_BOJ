import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        
        Queue<Integer> que = new ArrayDeque<>();
        int pass = 0;
        int targetTruck = 0;
        int onWeight = 0;
        int answer = 0;
        
        for(int i=0;i<bridge_length;i++) que.add(0);
        
        while(pass!=truck_weights.length){
            answer++;
            int a = que.poll();
            if(a!=0){
                onWeight-=a;
                pass++;
            }
            if(targetTruck>=truck_weights.length) continue;
            
            if(onWeight + truck_weights[targetTruck] <= weight){
                onWeight+=truck_weights[targetTruck];
                que.add(truck_weights[targetTruck++]);
            }else{
                que.add(0);
            }
        }
        
        return answer;
    }
}
import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        
        int answer = 0;
        Queue<Integer>que = new ArrayDeque<>();
        int[] priCnt = new int[10];
        
        for(int pri : priorities) {
            que.add(pri);
            priCnt[pri]++;
        }
        
        int cnt = 0;
        
        while(true){
            // System.out.println(que.toString());
            // System.out.println(location);
            // cnt++;
            // if(cnt == 10) break;
            
            boolean hasBig = false;
            int top = que.poll();
            location--;
            //우선순위 높은게 있는지 체크
            for(int i=top+1; i<10; i++){
                if(priCnt[i]>0){
                    que.add(top);
                    hasBig = true;
                    if(location < 0) location = que.size()-1;
                    break;
                }
            }
            if(hasBig)continue;
            //프로세스 실행
            answer++;
            priCnt[top]--;
            if(location < 0) break;
        }
        
        return answer;
    }
}
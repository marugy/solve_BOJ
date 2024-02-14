import java.util.*;

// K칸 점프 : K만큼의 건전지 사용
// 순간이동 : 현재까지 온 거리 X 2 해당하는 위치로 순간이동
// n까지 이동하는데 건전지 사용 최소화
public class Solution {
    
    public int solution(int n) {
        int use = 0;
        while(n>0){
            if(n%2==0) n/=2;
            else{
                n--;
                use++;
            } 
        }
        return use;
    }
}